package com.emgcy120.core.common.enm;

public enum ErrorCode {
	

	/** 令牌无效 */
	USER_ACCESS_TOKEN_ERROR_NOTEXISTS		(101,"令牌无效，请重新登录"),
	/** 令牌已过期 */
	USER_ACCESS_TOKEN_ERROR_OVERDUE			(102,"令牌已过期"),
	/** 令牌异常，未知错误 */
	USER_ACCESS_TOKEN_ERROR_EXCEPTION		(103,"令牌异常:"),
	/** refreshToken 不能为空 */
	USER_ACCESS_TOKEN_ERROR_REFRESH_IS_NULL	(104,"refreshToken 不能为空"),
	/** refreshToken 错误或不存在 */
	USER_ACCESS_TOKEN_ERROR_REFRESH_ERROR	(105,"refreshToken 错误或不存在"),
	USER_ACCESS_TOKEN_GENERATE_ERROR		( 106 , "生成令牌失败" ) ,
	
	/** 主键ID为空或格式错误 */
	PRIMARY_KEY_IS_NULL_OR_DATA_ERROR		(210,"主键ID为空或格式错误"),
	
	/** 日期格式错误 */
	DATA_FORMAT_ERROR						(401,"日期格式错误"),
	/** 请求数据格式异常 */
	PARAMS_ERROR							(402,"请求数据格式异常"),
	REQUEST_PARAM_ERROR						( 403 , "请求参数异常:" ) ,

	CONTACTS_EXISTED						( 501 , "联系人已经存在" ) ,
	BLACKLIST_EXISTED						( 502 , "该号码已经加入黑名单" ) ,
	EVENT_NOT_EXISTED						( 503 , "受理事件不存在" ) ,
	STAFF_NOT_EXISTED						( 504 , "人员不存在" ) ,
	USER_NOT_EXISTED						( 505 , "用户不存在" ) ,
	CONTACTS_NOT_EXISTED					( 506 , "联系人不存在" ) ,
	PWD_APPLY_NOT_EXISTED					( 507 , "重置密码申请记录不存在" ) ,
	OLD_PASSWORD_ERROR						( 508 , "旧密码错误" ) ,
	FILE_IS_EMPTY							( 509 , "文件为空" ) ,
	REQUEST_RESOURCE_NOT_EXIST				( 510 , "请求资源不存在" ) ,
	IN_HOSP_ERROR							( 511 , "访问院内服务器报错：" ) ,

	/** 未登录 */
	UNDOWN_LOGIN							(902,"未登录"),
	/** 用户名不能为空 */
	LOGIN_NAME_NULL_OR_EMPTY				(903,"用户名不能为空"),
	/** 用户密码不能为空 */
	LOGIN_PASSWORD_NULL_OR_EMPTY			(904,"用户密码不能为空"),
	/** 外部系统 ID或密码错误 */
	PASSWORD_ERROR							(905,"用户名或密码错误"),
	/** 登录失败 */
	LOGIN_ACCOUNT_FAIL						(906,"登录失败:"),
	/** 登录失败，系统异常 */
	LOGIN_ACCOUNT_FAIL_EXCEPTION			(907,"登录失败，系统异常"),
	LOGIN_PASSWORD_TOO_SHORT				( 908 , "密码位数不足" ) ,
	ACCOUNT_NEVER_ACTIVATE					( 909 , "账号未激活,请先激活账号" ) ,
	ACCOUNT_IS_DISABLE						( 910 , "账号已被停用,请联系管理员" ) ,
	ACCOUNT_MULTI_USER_ERROR				( 911 , "账号对应多个用户,请联系管理员" ) ,

	
	/** 未知错误 */
	UNKNOWN									(9999,"未知错误"),
	SERVER_ERROR							(9998,"服务器错误"),
	/** 成功 */
	SUCCESS									(200,"操作成功");
	

	
	private int code;
	private String description;

	ErrorCode(String description) {
        this.description = description;
    }
	
	ErrorCode(int code,String description) {
		this.code = code;
        this.description = description;
    }
	
	@Override
	public String toString() {
		return this.description;
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return this.code;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * 自定义错误提示, 错误代码为9999
	 * @param desc
	 * @return
	 */
	public static ErrorCode customDesc(String desc){
		UNKNOWN.description = desc;
		return UNKNOWN;
	}
	
	public static ErrorCode valueOf(int code){
		for (ErrorCode errorCode:values()) {
			if (errorCode.code == code){
				return errorCode;
			}
		}
		return null;
	}
}
