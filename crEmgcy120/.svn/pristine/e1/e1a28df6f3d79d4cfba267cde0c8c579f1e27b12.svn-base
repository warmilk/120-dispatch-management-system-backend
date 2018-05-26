package com.emgcy120.core.system.base;

import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.constants.ReturnCode;
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
public class BasePageResDto<T> extends BaseResDto implements Serializable {

	private static final long serialVersionUID = -446686529102260403L;

	/** 返回数据总数 */
	@ApiModelProperty(value="数据总数")
	private int total ;
	/** 返回数据列表 */
	@ApiModelProperty(value="数据")
	private List<T> list ;

	public BasePageResDto() {
		super();
		list = new ArrayList<T>();
	}

	public BasePageResDto(List<T> list, int total ) {
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

	public static BasePageResDto getSuccess(Page page ){

		BasePageResDto dto = new BasePageResDto() ;
		dto.setReturnCode( ReturnCode.RETURN_CODE_SUCCESS ) ;
		dto.setTotal( page.getTotal() ) ;
		dto.setList( page.getRecords() ) ;

		return dto ;

	}

    public static BasePageResDto getSuccess(int total, List list ) {

		BasePageResDto dto = new BasePageResDto() ;
		dto.setReturnCode( ReturnCode.RETURN_CODE_SUCCESS ) ;
		dto.setTotal( total ) ;
		dto.setList( list ) ;

		return dto ;

    }
}
