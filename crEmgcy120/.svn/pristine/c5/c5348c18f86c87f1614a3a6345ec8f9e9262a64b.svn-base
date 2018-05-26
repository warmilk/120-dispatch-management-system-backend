package com.emgcy120.core.system.call.entity;

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
 * @since 2017-11-21
 */
@TableName("cr_call_record_120")
public class CallRecord120 extends Model<CallRecord120> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
	private String id;
    /**
     * 电话id
     */
	@TableField("phone_id")
    @ApiModelProperty(value = "phone_id")
	private Long phoneId;
    /**
     * 用户id
     */
	@TableField("user_id")
    @ApiModelProperty(value = "user_id")
	private Long userId;
    /**
     * 呼叫类型（1、呼入；2、呼出）
     */
	@TableField("call_type")
    @ApiModelProperty(value = "call_type")
	private Integer callType;
    /**
     * 呼叫时间
     */
	@TableField("call_time")
    @ApiModelProperty(value = "call_time")
	private Date callTime;
    /**
     * 接通时间
     */
	@TableField("connect_time")
    @ApiModelProperty(value = "connect_time")
	private Date connectTime;
    /**
     * 通话结束时间
     */
	@TableField("end_time")
    @ApiModelProperty(value = "end_time")
	private Date endTime;
    /**
     * 通话时长，单位秒
     */
	@TableField("talk_time")
    @ApiModelProperty(value = "talk_time")
	private Integer talkTime;
    /**
     * 是否已接听（1、已接听；2、未接听）
     */
	@TableField("had_connected")
    @ApiModelProperty(value = "had_connected")
	private Integer hadConnected;
    /**
     * 响铃次数
     */
	@TableField("bell_count")
    @ApiModelProperty(value = "bell_count")
	private Integer bellCount;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getCallType() {
		return callType;
	}

	public void setCallType(Integer callType) {
		this.callType = callType;
	}

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}

	public Date getConnectTime() {
		return connectTime;
	}

	public void setConnectTime(Date connectTime) {
		this.connectTime = connectTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(Integer talkTime) {
		this.talkTime = talkTime;
	}

	public Integer getHadConnected() {
		return hadConnected;
	}

	public void setHadConnected(Integer hadConnected) {
		this.hadConnected = hadConnected;
	}

	public Integer getBellCount() {
		return bellCount;
	}

	public void setBellCount(Integer bellCount) {
		this.bellCount = bellCount;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CallRecord120{" +
			"id=" + id +
			", phoneId=" + phoneId +
			", userId=" + userId +
			", callType=" + callType +
			", callTime=" + callTime +
			", connectTime=" + connectTime +
			", endTime=" + endTime +
			", talkTime=" + talkTime +
			", hadConnected=" + hadConnected +
			", bellCount=" + bellCount +
			"}";
	}
}
