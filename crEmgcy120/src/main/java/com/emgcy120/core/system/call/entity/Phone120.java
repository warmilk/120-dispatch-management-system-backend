package com.emgcy120.core.system.call.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
@Data
@TableName("cr_phone_120")
public class Phone120 extends Model<Phone120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
	@TableId(value="id", type= IdType.AUTO)
    @ApiModelProperty(value = "id")
	private Long id;
    /**
     * 类型（1、手机；2、固话）
     */
	@TableField("phone_type")
    @ApiModelProperty(value = "phone_type")
	private Integer phoneType;
    /**
     * 号码
     */
    @ApiModelProperty(value = "number")
	private String number;
	/**
	 * 归属地
	 */
	@ApiModelProperty(value = "ascription")
	private String ascription;
	/**
	 * 最后一次通话时间
	 */
	@ApiModelProperty(value = "last_time")
	private String lastTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
