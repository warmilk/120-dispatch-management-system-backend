package com.emgcy120.core.common.shiro;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

/**
 * 
 * @author chenshuzhuo
 * @date 2017-10-20
 *
 */
@Configuration
public class ShiroConfiguration {

	public static final int HASH_INTERATIONS = 1024;

	@Bean
	public FilterRegistrationBean delegatingFilterProxy() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		DelegatingFilterProxy proxy = new DelegatingFilterProxy();
		proxy.setTargetFilterLifecycle(true);
		proxy.setTargetBeanName("shiroFilter");
		filterRegistrationBean.setFilter(proxy);
		return filterRegistrationBean;
	}

	@Bean("sessionManager")
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		// session 失效时长 30min 这里单位毫秒
		sessionManager.setGlobalSessionTimeout(1800000);
		sessionManager.setDeleteInvalidSessions(true);

		//是否开启会话验证器，默认是开启的
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setSessionValidationScheduler(sessionValidationScheduler());
		sessionManager.setSessionIdUrlRewritingEnabled(false);
		//Shiro提供SessionDAO用于会话的CRUD
		sessionManager.setSessionDAO(sessionDao());
//		sessionManager.setSessionIdCookieEnabled(true);
//		sessionManager.setSessionIdCookie(sessionIdCookie());
		return sessionManager;
	}

	@Bean
	public SecurityManager securityManager(ShiroRealm authRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(authRealm);
//		securityManager.setRememberMeManager(rememberMeManager());
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		//oauth过滤
		Map<String, Filter> filters = new HashMap<>();
		filters.put("oauth2", new ShiroOAuthFilter());
		shiroFilterFactoryBean.setFilters(filters);

		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

		filterChainDefinitionMap.put("/webjars/**", "anon");
		filterChainDefinitionMap.put("/druid/**", "anon");
		filterChainDefinitionMap.put("/api/**", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/**/*.css", "anon");
		filterChainDefinitionMap.put("/**/*.js", "anon");
		filterChainDefinitionMap.put("/**/*.html", "anon");
		filterChainDefinitionMap.put("/plugins/**", "anon");
		filterChainDefinitionMap.put("/swagger**/**", "anon");
		filterChainDefinitionMap.put("/v2/**", "anon");
		filterChainDefinitionMap.put("/configuration/**", "anon");
		filterChainDefinitionMap.put("/fonts/**", "anon");
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		filterChainDefinitionMap.put("/*.ftl", "anon");
		filterChainDefinitionMap.put("/testSwagger2/**", "anon");
		filterChainDefinitionMap.put("/pwdApply/apply", "anon");
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/**", "oauth2");


		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean( "lifecycleBeanPostProcessor" )
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		creator.setProxyTargetClass(true);
		return creator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager manager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(manager);
		return advisor;
	}

	/**
	 * 会话验证调度器
	 *
	 * @return
	 */
	@Bean
	public ExecutorServiceSessionValidationScheduler sessionValidationScheduler() {
		ExecutorServiceSessionValidationScheduler scheduler = new ExecutorServiceSessionValidationScheduler();
		// 这里单位毫秒(默认1小时)，30分钟内没有访问会话将过期
		scheduler.setInterval(1800000);
		return scheduler;
	}

	@Bean
	public EnterpriseCacheSessionDAO sessionDao() {
		EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
		sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
		sessionDAO.setSessionIdGenerator(sessionIdGenerator());
		return sessionDAO;
	}

	//	@Bean
//	public ShiroRealm myShiroRealm() {
//		ShiroRealm myShiroRealm = new ShiroRealm();
//		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//		myShiroRealm.setCacheManager(ehCacheManager());
//		return myShiroRealm;
//	}
//
//	@Bean
//	public CredentialsMatcher hashedCredentialsMatcher() {
//		HashedCredentialsMatcher hashedCredentialsMatcher = new ShiroHashedCredentialsMatcher(ehCacheManager());
//		hashedCredentialsMatcher.setHashAlgorithmName("SHA1");
//		hashedCredentialsMatcher.setHashIterations(HASH_INTERATIONS);
//		return hashedCredentialsMatcher;
//	}
//

	/**
	 * 会话ID生成器，用于生成会话ID
	 *
	 * @return
	 */
	@Bean
	public JavaUuidSessionIdGenerator sessionIdGenerator() {
		return new JavaUuidSessionIdGenerator();
	}

	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:cache/ehcache-shiro.xml");
		return cacheManager;
	}

//
//	@Bean
//	public SimpleCookie rememberMeCookie() {
//		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//		simpleCookie.setHttpOnly(true);
//		// 这里单位秒 3天失效
//		simpleCookie.setMaxAge(3 * 24 * 60 * 60);
//		return simpleCookie;
//	}
//
//	@Bean
//	public CookieRememberMeManager rememberMeManager() {
//		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//		cookieRememberMeManager.setCookie(rememberMeCookie());
//		// rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//		cookieRememberMeManager.setCipherKey(Base64.decode("8AvVhdsgUs0FSA3SDFAdag=="));
//		return cookieRememberMeManager;
//	}
//
//	@Bean
//	public SimpleCookie sessionIdCookie() {
//		SimpleCookie sc = new SimpleCookie("sid");
//		/*
//		 * 如果设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
//		 * 此特性需要实现了Servlet 2.5 MR6及以上版本的规范的Servlet容器支持
//		 */
//		sc.setHttpOnly(true);
//		sc.setMaxAge(-1);
//		return sc;
//	}

}
