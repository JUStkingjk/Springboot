package com.official.project001.shiro;

import com.official.project001.entity.Login;
import com.official.project001.entity.User;
import com.official.project001.service.LoginService;
import com.official.project001.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    @Resource
    private LoginService loginService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        //根据用户名从数据库查询该用户
        User user = userService.getByUsername(username);
        Login login = loginService.getByUsername(username);
        if(user != null){
            //把用户存到session中
            SecurityUtils.getSubject().getSession().setAttribute("user",user);
            //传入用户名和密码进行身份认证，返回认证信息
            return new SimpleAuthenticationInfo(login.getUsername(),login.getPassword(),"myRealm");
        }else{
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //给该用户设置角色
        authorizationInfo.setRoles(userService.getRole(username));
        //设置权限
        authorizationInfo.setStringPermissions(userService.getPermissions(username));
        return authorizationInfo;
    }
}
