package com.emgcy120.core.common.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.system.sys.entity.*;
import com.emgcy120.core.system.sys.service.IShiroService;
import com.emgcy120.core.system.sys.service.IUser120Service;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author chenshuzhuo
 * @data 2017-10-21
 *
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

	private static final Logger log = LoggerFactory.getLogger(ShiroRealm.class);

	@Autowired
	private IShiroService shiroService ;
	@Autowired
	private IUser120Service userService;

	/**
	 * 授权(验证权限时调用)
	 * 配置成功缓存这方法不会每次执行
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User120 user = (User120)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (user!=null) {
			Long userId = user.getId();
			//用户权限列表
//			Set<String> permsSet = shiroService.getUserPermissions(userId);
//			info.setStringPermissions(permsSet);
			Set<String> rolesSet = userService.getRoles( userId ) ;
			info.setRoles( rolesSet );

			//设置用户session
			ShiroUserUtil.setUserToSession( user ) ;

		}
		return info;

//		return new SimpleAuthorizationInfo() ;

	}

	/**
	 * 认证(登录时调用)
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {

		String accessToken = (String) authenticationToken.getPrincipal();

		//根据accessToken，查询用户信息
		UserToken120 tokenEntity = shiroService.queryByToken(accessToken);
		//token失效
		if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
//			throw new IncorrectCredentialsException("token失效，请重新登录");
			throw new ShiroCustomException( ErrorCode.USER_ACCESS_TOKEN_ERROR_NOTEXISTS ) ;
		}

		//查询用户信息
		User120 user = shiroService.queryUser(tokenEntity.getUserId());
		//账号未激活或已停用
		if (user.getStatus()== 0) {
//			throw new LockedAccountException("账号未激活,请先激活账号");
			throw new ShiroCustomException( ErrorCode.ACCOUNT_NEVER_ACTIVATE ) ;
		}
		if (user.getStatus()== -1) {
//			throw new LockedAccountException("账号已被停用,请联系管理员");
			throw new ShiroCustomException( ErrorCode.ACCOUNT_IS_DISABLE ) ;
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());

		return info;

//		ShiroLoginToken token = (ShiroLoginToken) authenticationToken;
//
//		if (StringUtils.isBlank(token.getUsername())) {
//			String errorMsg = "";
////			if (ShiroLoginToken.LOGIN_TYPE_EMPID.equals(token.getLoginType())) {
////				errorMsg = "请输入员工号";
////			} else {
////				errorMsg = "请输入账号";
////			}
////			throw new IncorrectCredentialsException(errorMsg);
//			throw new IncorrectCredentialsException( "请输入账号" ) ;
//		}
//
//		if (null == token.getPassword()) {
//			throw new IncorrectCredentialsException("请输入密码");
//		}
//
//		EntityWrapper<User120> userWrapper = new EntityWrapper<>();
////		if (ShiroLoginToken.LOGIN_TYPE_PHONE.equals(token.getLoginType())){
////			userWrapper.eq("phone", token.getUsername());
////		} else{
////			userWrapper.eq("employee_id", token.getUsername());
////		}
//		userWrapper.eq( "email" , token.getUsername() ) ;
//		List<User120> userList = userService.selectList(userWrapper);
//
//		if(userList==null||userList.size()==0){
//			throw new IncorrectCredentialsException("账号不存在");
//		}else if(userList.size()>1){
//			throw new IncorrectCredentialsException("账号对应多个用户,请联系管理员");
//		} else{
//			User120 user = userList.get(0);
//			if (user.getStatus()== 0) {
//				throw new LockedAccountException("账号未激活,请先激活账号");
//			}
//			if (user.getStatus()== -1) {
//				throw new LockedAccountException("账号已被停用,请联系管理员");
//			}
//			//设置用户session
//			ShiroUserUtil.setUserToSession(user);
//			return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
//
//		}

	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return true ;
	}
}
