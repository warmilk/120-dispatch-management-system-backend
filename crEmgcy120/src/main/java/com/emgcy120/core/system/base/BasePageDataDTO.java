package com.emgcy120.core.system.base;

import com.emgcy120.core.common.constants.ReturnCode;
import com.emgcy120.core.system.call.web.dto.CallRecordBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author chenshuzhuo layui.table 返回数据
 * @param <T>
 */
@ApiModel(value="分页数据类")
public class BasePageDataDTO<T> extends BaseResDto implements Serializable {

	private static final long serialVersionUID = -446686529102260403L;

	/** 返回数据总数 */
	@ApiModelProperty(value="数据总数")
	private int total ;
	/** 返回数据列表 */
	@ApiModelProperty(value="数据")
	private List<T> list ;

	public BasePageDataDTO() {
		super();
		list = new ArrayList<T>();
	}

	public BasePageDataDTO(List<T> list, int total ) {
		this.list = list ;
		this.total = total ;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

    public static BasePageDataDTO success(int total, List<CallRecordBean> list ) {

		BasePageDataDTO dto = new BasePageDataDTO() ;
		dto.setReturnCode( ReturnCode.RETURN_CODE_SUCCESS ) ;
		dto.setTotal( total ) ;
		dto.setList( list ) ;

		return dto ;

    }
}
