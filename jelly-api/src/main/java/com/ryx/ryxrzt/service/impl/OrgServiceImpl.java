package com.ryx.ryxrzt.service.impl;

import com.ryx.ryxrzt.entity.UserOrg;
import com.ryx.ryxrzt.entity.UserOrgExample;
import com.ryx.ryxrzt.mapper.SequenceMapper;
import com.ryx.ryxrzt.mapper.UserOrgMapper;
import com.ryx.ryxrzt.service.OrgService;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrgServiceImpl implements OrgService {
	@Autowired
	private UserOrgMapper userOrgMapper;
	@Autowired
	private SequenceMapper sequenceMapper;

	@Override
	public JsonResult addUserOrg(UserOrg userOrg) {
		
		UUID uuid = UUID.randomUUID();
		
		userOrg.setUuid(uuid.toString());
		
		String id = sequenceMapper.selectUserOrgSeq();
		
		userOrg.setId(id);
		
		int flag = userOrgMapper.insert(userOrg);
		
		if(flag == 1){
			return JsonResult.SUCCESS();
		}
		else{
			return JsonResult.FAIL();
		}
		
		
	}

	@Override
	public JsonResult updateUserOrg(UserOrg userOrg) {
		
		int flag = userOrgMapper.updateByPrimaryKey(userOrg);
		
		if(flag == 1){
			return JsonResult.SUCCESS();
		}
		else{
			return JsonResult.FAIL();
		}
	}

	@Override
	public List<UserOrg> findUserOrg(UserOrg userOrg) {
		
		UserOrgExample example = new UserOrgExample();
		
		List<UserOrg> list = userOrgMapper.selectByExample(example);
		return list;
	}

	@Override
	public JsonResult findById(UserOrg userOrg) {
		JsonResult jsonResult;
		UserOrgExample example = new UserOrgExample();
		UserOrgExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(userOrg.getId());
		/*List<UserOrg> list = userOrgMapper.selectByExample(example);*/
		userOrg = userOrgMapper.selectByPrimaryKey(userOrg.getId());
		jsonResult=new JsonResult(ConstantUtil.SUCCESS_CODE,ConstantUtil.QUERY_SUCCESS_MSG);
		jsonResult.setResult(userOrg);
		return  jsonResult;

	}

	@Override
	public List<UserOrg> findUserOrgByPid(UserOrg userOrg) {
		
		UserOrgExample example = new UserOrgExample();
		UserOrgExample.Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(userOrg.getPid());
		List<UserOrg> list = userOrgMapper.selectByExample(example);
		
		return list;
		
	}

	@Override
	public String getFatherIds(UserOrg userOrg) {
		return null;
	}

	@Override
	public JsonResult upadteUserOrg(UserOrg userOrg) {
		return null;
	}
	
	

}
