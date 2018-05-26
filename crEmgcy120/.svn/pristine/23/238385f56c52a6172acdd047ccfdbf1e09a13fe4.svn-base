package com.emgcy120.core.system.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 字典明细表
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-05
 */
@TableName("cr_dict_item")
public class DictItem extends Model<DictItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 字典明细ID
     */
	@TableId(value="id", type= IdType.AUTO)
    @ApiModelProperty(value = "id")
	private Long id;
    /**
     * 字典ID
     */
	@TableField("dict_id")
    @ApiModelProperty(value = "dict_id")
	private Long dictId;
    /**
     * 字典项代码
     */
	@TableField("dict_item_key")
    @ApiModelProperty(value = "dict_item_key")
	private String dictItemKey;
    /**
     * 字典项值
     */
	@TableField("dict_item_value")
    @ApiModelProperty(value = "dict_item_value")
	private String dictItemValue;
    /**
     * 排序号
     */
    @ApiModelProperty(value = "sort")
	private Integer sort;
    /**
     * 是否启用(0:禁用,1:启用)
     */
	@TableField("is_enable")
    @ApiModelProperty(value = "is_enable")
	private Integer isEnable;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDictId() {
		return dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getDictItemKey() {
		return dictItemKey;
	}

	public void setDictItemKey(String dictItemKey) {
		this.dictItemKey = dictItemKey;
	}

	public String getDictItemValue() {
		return dictItemValue;
	}

	public void setDictItemValue(String dictItemValue) {
		this.dictItemValue = dictItemValue;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "DictItem{" +
			"id=" + id +
			", dictId=" + dictId +
			", dictItemKey=" + dictItemKey +
			", dictItemValue=" + dictItemValue +
			", sort=" + sort +
			", isEnable=" + isEnable +
			"}";
	}
}
