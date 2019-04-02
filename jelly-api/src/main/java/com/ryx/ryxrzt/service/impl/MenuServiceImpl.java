package com.ryx.ryxrzt.service.impl;

import com.ryx.ryxrzt.entity.Menu;
import com.ryx.ryxrzt.entity.MenuExample;
import com.ryx.ryxrzt.entity.RoleAndMenu;
import com.ryx.ryxrzt.entity.UserInfo;
import com.ryx.ryxrzt.mapper.MenuMapper;
import com.ryx.ryxrzt.mapper.RoleAndMenuMapper;
import com.ryx.ryxrzt.mapper.SequenceMapper;
import com.ryx.ryxrzt.service.MenuService;
import com.ryx.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private RoleAndMenuMapper roleAndMenuMapper;




    @Override
	public JsonResult addMenu(Menu menu) {
		
		String id = sequenceMapper.selectMenuSeq();
		
		menu.setId(id);
		
		int flag = menuMapper.insert(menu);
		
		if(flag == 1){
			return JsonResult.SUCCESS();
		}
		else{
			return JsonResult.FAIL();
		}
		
	}

	@Override
	public JsonResult updateMenu(Menu menu) {
		return null;
	}

	@Override
	public List<Menu> findMenu(Menu menu) {
		MenuExample example = new MenuExample();
		MenuExample.Criteria criteria = example.createCriteria();
		boolean flag = true;
		if(!StringUtils.isEmpty(menu.getName())) {
			criteria.andNameLike(menu.getName());
			flag = false;
		}
		if(!StringUtils.isEmpty(menu.getRemark())){
			criteria.andIdEqualTo(menu.getRemark());
			flag = false;
		}
		if(flag){
			criteria.andPidEqualTo("0");
		}
		
		List<Menu> list = menuMapper.selectByExample(example);
		return list;
	}
	
	

	@Override
	public JsonResult findMenuByPid(Menu menu) {
		
		MenuExample example = new MenuExample();


		MenuExample.Criteria criteria = example.createCriteria();


		if(StringUtils.isNotBlank(menu.getName()) || StringUtils.isNotBlank(menu.getRemark())){

		    if(StringUtils.isNotBlank(menu.getRemark())){
                criteria.andIdEqualTo(menu.getRemark());
            }
            if(StringUtils.isNotBlank(menu.getName())){
                criteria.andNameLike(menu.getName());
            }
        }
        else{
            criteria.andPidEqualTo(menu.getPid());
        }


		List<Menu> list = menuMapper.selectByExample(example);

		JsonResult result = JsonResult.SUCCESS();
		result.setResult(list);

		return result;
		
	}
	
	@Override
	public JsonResult findById(Menu menu) {
		menu = menuMapper.selectByPrimaryKey(menu.getId());

		JsonResult jsonResult= JsonResult.SUCCESS();
		jsonResult.setResult(menu);
		return  jsonResult;
	}

	@Override
	public String getFatherIds(Menu menu) {
		
		StringBuffer str = new StringBuffer();
		
		getFatherIds(menu.getId(),str);
		
		return str.toString();
		
	}
	
	public void getFatherIds(String id, StringBuffer str){
		str.append(id);
		MenuExample example = new MenuExample();
		MenuExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		Menu menu = menuMapper.selectByPrimaryKey(id);
		if(!"0".equals(menu.getPid())){
			str.append(",");
			getFatherIds(menu.getPid(),str);
		}
	}

	@Override
	public JsonResult upadteMenu(Menu menu) {
		int flag = menuMapper.updateByPrimaryKey(menu);
		
		if(flag == 1){
			return JsonResult.SUCCESS();
		}
		else{
			return JsonResult.FAIL();
		}
	}

	@Override
	public List<RoleAndMenu> selectPermissionByLoginName(UserInfo userinfo){
		return roleAndMenuMapper.selectPermissionByLoginName(userinfo);

	}

    @Override
    public Menu getMenuByUrl(String url){

        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andUrlEqualTo(url);
        List<Menu> menuList = menuMapper.selectByExample(example);
        if(menuList == null || menuList.size()==0){
            return null;
        }
        else{
            Menu menu = menuList.get(0);
            return menu;
        }


    }
	

}
