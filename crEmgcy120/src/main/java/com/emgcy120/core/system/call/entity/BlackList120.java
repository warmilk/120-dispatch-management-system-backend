package com.emgcy120.core.system.call.entity;

import java.io.Serializable;

import java.util.Date;
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
@TableName("cr_black_list_120")
public class BlackList120 extends Model<BlackList120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
	@TableId(value="id", type= IdType.AUTO)
    @ApiModelProperty(value = "id")
	private Long id;
    /**
     * 电话id
     */
	@TableField("phone_id")
    @ApiModelProperty(value = "phone_id")
	private Long phoneId;
	/**
     * 操作用户id
     */
	@TableField("user_id")
    @ApiModelProperty(value = "user_id")
	private Long userId;
    /**
     * 新建时间
     */
	@TableField("create_time")
    @ApiModelProperty(value = "create_time")
	private Date createTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
