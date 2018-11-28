package com.jelly.ssm.service.impl;

import com.jelly.ssm.dao.PermissionDao;
import com.jelly.ssm.entity.Permission;
import com.jelly.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<Permission,Integer> implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> permissionList(Integer roleId) {
        return permissionDao.permissionList(roleId);
    }
}
