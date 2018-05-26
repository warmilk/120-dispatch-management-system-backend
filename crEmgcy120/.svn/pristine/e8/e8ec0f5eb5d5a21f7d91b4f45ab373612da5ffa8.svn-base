package com.emgcy120.core.system.base;

import com.emgcy120.core.common.enm.ErrorCode;

import java.io.Serializable;

public class BaseJsonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3371485021901731234L;
	private boolean success;
	private String errorCode;
	private String msg;
	private int totalCount;
	private String returnId;
	private String otherProperty;
	private Object data;

	public BaseJsonDTO() {
		this.success = false;
	}

	public void setError(ErrorCode code) {
		this.errorCode = "" + code.getCode();
		this.msg = code.getDescription();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getReturnId() {
		return returnId;
	}

	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}

	public String getOtherProperty() {
		return otherProperty;
	}

	public void setOtherProperty(String otherProperty) {
		this.otherProperty = otherProperty;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	/**
	 * 设置成功消息
	 * @param msg
	 */
	public void setSuccessMsg(String msg) {
		this.success = true;
		this.msg = msg;
	}
	
	/**
	 * 设置失败消息
	 * @param msg
	 */
	public void setErrorMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 返回对象
	 * @param data
	 * @return
	 */
	public static BaseJsonDTO ok(Object data) {
		BaseJsonDTO baseJsonDTO = new BaseJsonDTO();
		baseJsonDTO.setSuccess(true);
		baseJsonDTO.setData(data);
		return baseJsonDTO;
	}

}
