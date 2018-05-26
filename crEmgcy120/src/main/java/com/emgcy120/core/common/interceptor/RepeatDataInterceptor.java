package com.emgcy120.core.common.interceptor;

import com.emgcy120.core.common.annotation.RepeatUrlData;
import net.sf.json.JSONArray;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author chenshuzhuo
 * @date 2017-11-15
 */
public class RepeatDataInterceptor extends HandlerInterceptorAdapter {

	private static final String REPEAT_DATA = "repeatData";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			RepeatUrlData annotation = method.getAnnotation(RepeatUrlData.class);
			if (annotation != null) {
				if (repeatDataValidator(request)) {
					return false;
				} else {
					return true;
				}

			}
			return true;
		} else {
			return super.preHandle(request, response, handler);
		}

	}

	public boolean repeatDataValidator(HttpServletRequest httpServletRequest) {
		String params = JSONArray.fromObject(httpServletRequest.getParameterMap()).toString();
		String url = httpServletRequest.getRequestURI();
		Map<String, String> map = new HashMap<String, String>();
		map.put(url, params);
		String nowUrlParams = map.toString();
		HttpSession session = httpServletRequest.getSession();
		Object preUrlParams = session.getAttribute(REPEAT_DATA);
		if (preUrlParams == null) {
			session.setAttribute(REPEAT_DATA, nowUrlParams);
			return false;
		} else {
			if (preUrlParams.toString().equals(nowUrlParams)) {
				return true;
			} else {
				session.setAttribute(REPEAT_DATA, nowUrlParams);
				return false;
			}

		}
	}

}
