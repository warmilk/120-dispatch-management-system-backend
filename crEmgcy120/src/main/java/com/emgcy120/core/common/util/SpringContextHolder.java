package com.emgcy120.core.common.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.
 * 
 * @author alex
 */
@Component
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware,
		DisposableBean {

	/**
	 * Spring的ApplicationContext
	 */
	private static ApplicationContext applicationContext = null;

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(SpringContextHolder.class);

	/**
	 * 实现ApplicationContextAware接口, 注入Context到静态变量中.
	 * 
	 * @param applicationContext
	 *            ApplicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		logger.debug("注入ApplicationContext到SpringContextHolder:"
				+ applicationContext);

		if (SpringContextHolder.applicationContext != null) {
			logger.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:"
					+ SpringContextHolder.applicationContext);
		}

		// NOSONAR
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 实现DisposableBean接口,在Context关闭时清理静态变量.
	 * 
	 * @throws Exception
	 *             Exception
	 */
	public void destroy() throws Exception {
		SpringContextHolder.clear();
	}

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 * 
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @param name
	 *            bean名称
	 * @param <T>
	 *            泛型类型
	 * @return Spring中的bean对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @param requiredType
	 *            转换的类型
	 * @param <T>
	 *            泛型类型
	 * @return Spring中的bean对象
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 从静态变量applicationContext中取得Beans, 自动转型为所赋值对象的类型.
	 * 
	 * @param requiredType
	 *            请求类型
	 * @param <T>
	 *            泛型
	 * @return 该类型及其子类的集合
	 */
	public static <T> Map<String, T> getBeans(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBeansOfType(requiredType);
	}

	/**
	 * 清除SpringContextHolder中的ApplicationContext为Null.
	 */
	public static void clear() {
		logger.debug("清除SpringContextHolder中的ApplicationContext:"
				+ applicationContext);
		applicationContext = null;
	}

	/**
	 * 检查ApplicationContext不为空.
	 */
	private static void assertContextInjected() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}
}
