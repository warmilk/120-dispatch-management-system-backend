package com.emgcy120.core.system.event.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-16
 */
@Data
@TableName("cr_assign_120")
public class Assign120 extends Model<Assign120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
    @TableId( value="id")
	private String id;
    /**
     * 事件id
     */
	@TableField("event_id")
	private String eventId;
    /**
     * 医院id
     */
	@TableField("hosp_id")
	private Long hospId;
    /**
     * 车辆数量
     */
	@TableField("car_num")
	private Integer carNum;
	/**
	 * 受理状态（1、待受理；2、已受理；3、未受理；4、派单超时；5、已取消）
	 */
	@TableField( "receive_status" )
	private Integer receiveStatus ;
	/**
	 * 执行状态：0、无，1、已出车；2、已到达；3、已中断；4、已完成
	 */
	@TableField( "execute_status" )
	private Integer executeStatus ;
	/**
	 * 受理人id，参照院内工作站的用户表
	 */
	@TableField( "receiver_id" )
	private Long receiverId ;
	/**
	 * 指派开始时间
	 */
	@TableField( "assign_start_time" )
	private Date assignStartTime ;
	/**
	 * 指派响应时间
	 */
	@TableField( "assign_res_time" )
	private Date assignResTime ;
	/**
	 * 取消时间
	 */
	@TableField( "assign_cancel_time" )
	private Date assignCancelTime ;
	/**
	 * 出车时间
	 */
	@TableField( "assign_car_time" )
	private Date assignCarTime ;
	/**
	 * 医生到达现场时间
	 */
	@TableField( "assign_arrive_time" )
	private Date assignArriveTime ;
	/**
	 * 中断时间
	 */
	@TableField( "assign_stop_time" )
	private Date assignStopTime ;
	/**
	 * 指派完成时间，指派的任务已经完成
	 */
	@TableField( "assign_finish_time" )
	private Date assignFinishTime ;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
