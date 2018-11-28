package com.jelly.shiro.study.service;

import com.jelly.shiro.study.entity.Permission;
import com.jelly.shiro.study.entity.Role;
import com.jelly.shiro.study.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Before
    public  void setUp() {
        jdbcTemplate.update("delete from t_user");
        jdbcTemplate.update("delete from t_role");
        jdbcTemplate.update("delete from t_permission");
        jdbcTemplate.update("delete from user_role");
        jdbcTemplate.update("delete from role_permission");
        //1 新增权限
        Permission p1 = new Permission("user:create", "用户模块新增", Boolean.TRUE);
        Permission p2 = new Permission("user:update", "用户模块修改", Boolean.TRUE);
        Permission p3 = new Permission("menu:create", "菜单模块新增", Boolean.TRUE);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        //2新增角色
        Role r1 = new Role("admin", "管理员", Boolean.TRUE);
        Role r2 = new Role("user", "用户管理员", Boolean.TRUE);
        roleService.createRole(r1);
        roleService.createRole(r2);
        //3关联角色权限
        roleService.correlationPermission(r1.getId(), p1.getId());
        roleService.correlationPermission(r1.getId(), p2.getId());
        roleService.correlationPermission(r1.getId(), p3.getId());

        roleService.correlationPermission(r2.getId(), p1.getId(), p2.getId());
        //4新增用户
        User u1 = new User("zhang", "123");
        User u2 = new User("lol", "123");
        User u3 = new User("wu", "123");
        User u4 = new User("wang", "123");
        u4.setLocked(Boolean.TRUE);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //5关联用户-角色
        userService.correlationRoles(u1.getId(),r1.getId());

    }

    @After
    public  void tearDwon()
    {
        ThreadContext.unbindSubject();
    }

}
