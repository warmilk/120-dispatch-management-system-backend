package com.emgcy120.core.system.base;

import com.emgcy120.core.common.util.Navigate;


public class BaseModel {

	/**
	 * 分页导航
	 */
	private Navigate navigate = new Navigate();

	public Navigate getNavigate() {
		return navigate;
	}

	public void setNavigate(Navigate navigate) {
		this.navigate = navigate;
	}
}
