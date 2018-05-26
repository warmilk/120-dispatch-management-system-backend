package com.emgcy120.core.system.event.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-04
 */
@Data
@TableName("cr_assign_car_120")
public class AssignCar120 extends Model<AssignCar120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
	@TableId(value="id", type= IdType.AUTO)
    @ApiModelProperty(value = "id")
	private Long id;
	/**
     * 标识ID
     */
	@TableField("assign_id")
    @ApiModelProperty(value = "assign_id")
	private Long assignId;
    /**
     * 车牌号
     */
	@TableField("plate_number")
    @ApiModelProperty(value = "plate_number")
	private String plateNumber;
    /**
     * 司机
     */
    @ApiModelProperty(value = "driver")
	private String driver;
    /**
     * 司机电话
     */
	@TableField("driver_phone")
    @ApiModelProperty(value = "driver_phone")
	private String driverPhone;
    /**
     * 出诊医生
     */
    @ApiModelProperty(value = "doctor")
	private String doctor;
    /**
     * 出诊护士
     */
    @ApiModelProperty(value = "nurse")
	private String nurse;
    /**
     * 担架员
     */
    @ApiModelProperty(value = "stretcher")
	private String stretcher;
    /**
     * 医院派单时间（派给医生的单）
     */
    @TableField( "hosp_assign_time" )
    @ApiModelProperty(value = "hosp_assign_time")
	private String hospAssignTime;
    /**
     * 调度人员
     */
    @ApiModelProperty(value = "dispatcher")
	private String dispatcher;
    /**
     * 出车状态
     */
    @ApiModelProperty(value = "status")
	private String status;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
