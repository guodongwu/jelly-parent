package com.ryx.ryxrzt.service.impl;

import com.ryx.ryxrzt.entity.*;
import com.ryx.ryxrzt.mapper.RoleAndMenuMapper;
import com.ryx.ryxrzt.mapper.SequenceMapper;
import com.ryx.ryxrzt.mapper.UserRoleMapper;
import com.ryx.ryxrzt.mapper.UserRoleMenuMapper;
import com.ryx.ryxrzt.service.UserRoleService;
import com.ryx.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private RoleAndMenuMapper roleAndMenuMapper;
	@Autowired
	private UserRoleMenuMapper userRoleMenuMapper;

	@Override
	public List<UserRole> FindUserRole(UserRole userRole) {
		
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(userRole.getId())){
			criteria.andIdEqualTo(userRole.getId());
		}
		List<UserRole> list = userRoleMapper.selectByExample(example);
		
		return list;
		
	}
	
	@Override
	public JsonResult findOne(UserRole userRole) {

        UserRole userRoles = userRoleMapper.selectByPrimaryKey(userRole.getId());
        JsonResult result=JsonResult.SUCCESS();
        result.setResult(userRoles);
		return result;
	}

	@Override
	public List<UserRole> FindUserRoleByPid(UserRole userRole) {
		
		UserRoleExample example = new UserRoleExample();
		
		UserRoleExample.Criteria criteria = example.createCriteria();
		
		criteria.andPidEqualTo(userRole.getPid());
		
		List<UserRole> list = userRoleMapper.selectByExample(example);
		
		return list;
		
	}

	@Override
	public JsonResult addUserRole(UserRole userRole) {
		
		String id = sequenceMapper.selectRoleSeq();
		
		userRole.setId(id);
		
		int flag = userRoleMapper.insert(userRole);
		if(1==flag){
			return JsonResult.SUCCESS();
		}
		else{
			return JsonResult.FAIL();
		}
		
	}

	@Override
	public JsonResult updateUserRole(UserRole userRole) {
		int flag = userRoleMapper.updateByPrimaryKey(userRole);
		if(1==flag){
			return JsonResult.SUCCESS();
		}
		else{
			return JsonResult.FAIL();
		}
	}

	@Override
	public List<RoleAndMenu> findRoleMenu(RoleAndMenu roleMenu) {
		
		if(StringUtils.isEmpty(roleMenu.getRoleId())){
			return new ArrayList<RoleAndMenu>();
		}
		
		return roleAndMenuMapper.selectByRoleId(roleMenu);
	}

	@Override
	public JsonResult addRoleMenu(UserRoleMenu roleMenu) {

		String menuIds = roleMenu.getMenuId();

		String[]menuIdsArray = menuIds.split(",");
		String ruleId = roleMenu.getRoleId();

		for(String menuId : menuIdsArray){
			UserRoleMenuExample example = new UserRoleMenuExample();
			UserRoleMenuExample.Criteria criteria = example.createCriteria();
			criteria.andMenuIdEqualTo(menuId);
			criteria.andRoleIdEqualTo(ruleId);
			long flag = userRoleMenuMapper.countByExample(example);
			if(flag == 0){
				roleMenu.setMenuId(menuId);
				userRoleMenuMapper.insert(roleMenu);
			}
		}
		return JsonResult.SUCCESS();

	}

	@Override
	public JsonResult deleteRoleMenu(UserRoleMenu roleMenu) {
		
		UserRoleMenuExample example = new UserRoleMenuExample();
		UserRoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andMenuIdEqualTo(roleMenu.getMenuId());
		criteria.andRoleIdEqualTo(roleMenu.getRoleId());
		int flag = userRoleMenuMapper.deleteByExample(example);
		if(1==flag){
			return JsonResult.SUCCESS();
		}
		else{
			return JsonResult.FAIL();
		}
	}

	
	

}
