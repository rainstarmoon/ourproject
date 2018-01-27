package com.project.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.pojo.Permission;
import com.project.pojo.Role;
import com.project.pojo.User;
import com.project.service.UserService;

public class MongodbRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user=(User) principals.getPrimaryPrincipal();
		for(Role role:user.getRoleList()) {
			authorizationInfo.addRole(role.getRolename());
			for(Permission permission:role.getPermissionList()) {
				 authorizationInfo.addStringPermission(permission.getType());
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=(String)token.getPrincipal();
		
		User user=new User();
		user.setUsername(username);
		user=userService.queryByUsername(user);
		if(user==null) {
			return null;
		}
				
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
				user,
				user.getPassword(),
				ByteSource.Util.bytes(user.getUsername()),
				this.getName()
		);
		return authenticationInfo;
	}

}
