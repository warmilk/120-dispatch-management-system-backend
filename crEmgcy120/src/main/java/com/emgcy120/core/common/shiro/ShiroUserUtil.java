package com.emgcy120.core.common.shiro;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.system.sys.entity.User120;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * 
 * @author chenshuzhuo
 * @date 2017-11-2
 */
public class ShiroUserUtil {
	
	
	/**
	 * 获取当前用户session
	 * @return session
	 */
	public static Session getCurrentUserSession(){
		return getSession(false);
	}
	
	/**
	 * 获取session对象
	 * @param flag
	 * @return
	 */
	public static Session getSession(boolean flag){
		Session session =SecurityUtils.getSubject().getSession(flag);
		return session;
	}
	
	/**
	 * 设置当前用户对象到session
	 * @return user
	 */
	public static void setUserToSession(User120 user){
		getSession(true).setAttribute(Constant.USER_SESSION_KEY, user);
	}
	
	/**
	 * session中获取当前用户对象
	 * @return user
	 */
	public static User120 getCurrentUser(){
		Session session =getCurrentUserSession();
		if(null!=session){
			return (User120) session.getAttribute(Constant.USER_SESSION_KEY);
		}else{
			return null;
		}
		
	}

	public static Object getSessionAttribute(Object key) {
		return getSession(true).getAttribute(key);
	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession(true).setAttribute(key, value);
	}

}
