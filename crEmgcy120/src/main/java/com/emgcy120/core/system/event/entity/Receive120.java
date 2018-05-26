package com.emgcy120.core.system.event.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-16
 */
@Data
@TableName("cr_receive_120")
public class Receive120 extends Model<Receive120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
    @TableId( "event_id" )
	private String eventId;
    /**
     * 开始时间，指派的医院第一家开始受理的时间
     */
	@TableField("start_time")
	private Date startTime;
    /**
     * 结束时间，指派的医院最后一家完成任务的时间
     */
	@TableField("end_time")
	private Date endTime;
	/**
	 * 指派医院数量
	 */
	@TableField( "hosp_num" )
	private Integer hospNum ;

	@Override
	protected Serializable pkVal() {
		return this.eventId;
	}

}
