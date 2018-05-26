package com.emgcy120.core.system.call.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("cr_contact_120")
public class Contact120 extends Model<Contact120> {

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
     * 单位名称
     */
    @ApiModelProperty(value = "org_name")
	private String orgName;
	/**
	 * 备注名称
	 */
	@ApiModelProperty(value = "remark_name")
	private String remarkName;
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
