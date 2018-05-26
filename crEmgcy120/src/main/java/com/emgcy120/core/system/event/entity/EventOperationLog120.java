package com.emgcy120.core.system.event.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-05
 */
@TableName("cr_event_operation_log_120")
public class EventOperationLog120 extends Model<EventOperationLog120> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
	private String id;
    /**
     * 事件id
     */
	@TableField("event_id")
    @ApiModelProperty(value = "event_id")
	private String eventId;
    /**
     * 操作时间
     */
	@TableField("ope_time")
    @ApiModelProperty(value = "ope_time")
	private Date opeTime;
    /**
     * 操作员
     */
    @ApiModelProperty(value = "operator")
	private String operator;
    /**
     * 操作类型，参照字典表中event_ope
     */
	@TableField("ope_type")
    @ApiModelProperty(value = "ope_type")
	private Long opeType;
    /**
     * 备注
     */
    @ApiModelProperty(value = "remark")
	private String remark;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getOpeTime() {
		return opeTime;
	}

	public void setOpeTime(Date opeTime) {
		this.opeTime = opeTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getOpeType() {
		return opeType;
	}

	public void setOpeType(Long opeType) {
		this.opeType = opeType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "EventOperationLog120{" +
			"id=" + id +
			", eventId=" + eventId +
			", opeTime=" + opeTime +
			", operator=" + operator +
			", opeType=" + opeType +
			", remark=" + remark +
			"}";
	}
}
