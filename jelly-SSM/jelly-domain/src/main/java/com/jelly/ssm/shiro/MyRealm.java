package com.jelly.ssm.shiro;


import com.jelly.ssm.entity.Permission;
import com.jelly.ssm.entity.Role;
import com.jelly.ssm.entity.User;
import com.jelly.ssm.service.PermissionService;
import com.jelly.ssm.service.RoleService;
import com.jelly.ssm.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Realm
 * @author wu
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username= (String) super.getAvailablePrincipal(principalCollection);

        List<String> roles=new ArrayList<String>();
        List<String> permissions=new ArrayList<String>();
        User user=userService.findUserByUserName(username);
        if(user!=null){
           Role role=roleService.roleList(user.getUserId()).get(0);
           roles.add(String.valueOf(role.getRoleId()));
           List<Permission> permissionList=permissionService.permissionList(role.getRoleId());
           for (Permission permission:permissionList){
               permissions.add(String.valueOf(permission.getPermissionId()));
           }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();
        if(StringUtils.isNotEmpty(username)){
            User user=userService.findUserByUserName(username);
            if(user!=null){
                return  new SimpleAuthenticationInfo(
                        user.getUsername(),
                        user.getPassword(),
                        ByteSource.Util.bytes(user.getCredentialsSalt()),
                        getName());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String algorithmName="md5";
        String username="admin";
        String password="admin";
        String salt1=username;
        String salt2=new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash hash=new SimpleHash(algorithmName,password,salt1+salt2,3);
        String encodedPassword=hash.toHex();
        System.out.println(encodedPassword);
        System.out.println(salt2);



    }
}
