package com.emgcy120.core.common.base;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class BaseMsg extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public BaseMsg() {
		put("code", 0);
	}

	/**
	 * 返回未知异常
	 * 
	 * @return
	 */
	public static BaseMsg error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}

	/**
	 * 返回后台报错(500) 消息
	 * 
	 * @param msg
	 * @return
	 */
	public static BaseMsg error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}

	/**
	 * 没报错！返回操作失败消息
	 * 
	 * @param msg
	 * @return
	 */
	public static BaseMsg errorMsg(String msg) {
		return error(0, msg);
	}

	/**
	 * 返回自定义错误
	 * 
	 * @param code
	 *            返回代码
	 * @param msg
	 *            返回消息
	 * @return
	 */
	public static BaseMsg error(int code, String msg) {
		BaseMsg r = new BaseMsg();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	/**
	 * 返回成功消息
	 * 
	 * @param msg
	 * @return
	 */
	public static BaseMsg successMsg(String msg) {
		BaseMsg r = new BaseMsg();
		r.put("msg", msg);
		return r;
	}

	/**
	 * 返回成功数据
	 * 
	 * @param obj
	 * @return
	 */
	public static BaseMsg successData(Object obj) {
		BaseMsg r = new BaseMsg();
		r.put("data", obj);
		return r;
	}

	/**
	 * 返回成功消息
	 * 
	 * @param map
	 * @return
	 */
	public static BaseMsg successMap(Map<String, Object> map) {
		BaseMsg r = new BaseMsg();
		r.putAll(map);
		return r;
	}

	/**
	 * 返回成功状态
	 * 
	 * @return
	 */
	public static BaseMsg success() {
		return new BaseMsg();
	}

	public BaseMsg put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
