package com.ryx.ryxrzt.service.impl;

import com.ryx.exception.MyException;
import com.ryx.ryxrzt.entity.UserInfo;
import com.ryx.ryxrzt.entity.UserInfoExample;
import com.ryx.ryxrzt.entity.UserInfoExpand;
import com.ryx.ryxrzt.mapper.SequenceMapper;
import com.ryx.ryxrzt.mapper.UserInfoMapper;
import com.ryx.ryxrzt.mapper.UserInfoMapperExp;
import com.ryx.ryxrzt.service.UserInfoService;
import com.ryx.utils.JsonResult;
import com.ryx.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private UserInfoMapperExp userInfoMapperExp;
	
	@Override
	public JsonResult add(UserInfo userInfo) {
		
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(userInfo.getLoginName());
		long cnt = userInfoMapper.countByExample(example);
		if(cnt>0){
			return new JsonResult("1000", "登录名称已存在!");
		}
		else{
			String id = sequenceMapper.selectUserInfoSeq();
			userInfo.setId(id);
			userInfo.setCreateDate(DateTime.now().toString("yyyyMMdd"));
			userInfo.setCreateTime(DateTime.now().toString("HHmmss"));

			String password = MD5Util.getPassWordSecret(userInfo.getPassword(),id);
			userInfo.setPassword(password);

			
			int flag = userInfoMapper.insert(userInfo);
			
			if(1==flag){
				return JsonResult.SUCCESS();
			}
			else{
				return JsonResult.FAIL();
			}
		}
		
	}

    @Override
    public JsonResult find(UserInfo userInfo) throws IllegalAccessException, InstantiationException {
        long total = userInfoMapperExp.selectUserInfoCnt(userInfo);


        userInfo.setBeginRows(userInfo.getRows()*(userInfo.getPage()-1));
        userInfo.setEndRows(userInfo.getRows()*userInfo.getPage());

        List<UserInfoExpand> list = userInfoMapperExp.selectUserInfo(userInfo);

        JsonResult result = JsonResult.SUCCESS();
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        map.put("items",list);
        result.setResult(map);
        return result;
    }


    @Override
	public JsonResult findUserInfo(UserInfo userInfo) {
		
		UserInfo info = userInfoMapper.selectByPrimaryKey(userInfo.getId());
		
		info.setPassword("");
		JsonResult result=JsonResult.SUCCESS();
		result.setResult(info);
		return result;
	}

	@Override
	public JsonResult update(UserInfo userInfo) {
		
		int flag = userInfoMapper.updateByPrimaryKeySelective(userInfo);
		
		if(1==flag){
			return JsonResult.SUCCESS();
		}
		else{
			return JsonResult.FAIL();
		}
	}

    @Override
    public UserInfo findByLoginName(String loginName) {
       try {
           UserInfoExample example = new UserInfoExample();
           UserInfoExample.Criteria criteria = example.createCriteria();
           criteria.andLoginNameEqualTo(loginName);
           List<UserInfo> list = userInfoMapper.selectByExample(example);

           if (list != null && list.size() > 0) {
               UserInfo userInfo = list.get(0);
               return userInfo;
           }
       }catch (Exception e){
           throw new MyException(e.getMessage());
       }
        return  null;
    }

    @Override
    public JsonResult updatePwd(UserInfo userInfo) {


        UserInfo user =  userInfoMapper.selectByPrimaryKey(userInfo.getId());

        String password = MD5Util.getPassWordSecret(user.getPassword(),userInfo.getId());
        userInfo.setPassword(password);

        int flag = userInfoMapper.updateByPrimaryKeySelective(userInfo);

        if(1==flag){
            return JsonResult.SUCCESS();
        }
        else{
            return JsonResult.FAIL();
        }


    }

    @Override
    public JsonResult updatePwdIndex(Map<String, String> userInfo) {


        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        UserInfo user =(UserInfo) session.getAttribute("userInfo");
        user =  userInfoMapper.selectByPrimaryKey(user.getId());

        if(!MD5Util.getPassWordSecret(userInfo.get("oldPassword"),user.getId()).equals(user.getPassword())){
            JsonResult jsonResult=new JsonResult();
            jsonResult.setCode("1001");
            jsonResult.setMsg("旧密码不正确");
            return jsonResult;
        }


        UserInfo updateInfo = new UserInfo();
        String password =MD5Util.getPassWordSecret(userInfo.get("password"),user.getId());
        updateInfo.setPassword(password);
        updateInfo.setId(user.getId());

        int flag = userInfoMapper.updateByPrimaryKeySelective(updateInfo);

        if(1==flag){
            return JsonResult.SUCCESS();
        }
        else{
            return JsonResult.FAIL();
        }


    }


}
