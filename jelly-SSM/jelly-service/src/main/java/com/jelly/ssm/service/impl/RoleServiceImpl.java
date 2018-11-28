package com.jelly.ssm.service.impl;

import com.jelly.ssm.dao.RoleDao;
import com.jelly.ssm.entity.Role;
import com.jelly.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<Role,Integer> implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> roleList(Integer userId) {
        return roleDao.roleList(userId);
    }
}
