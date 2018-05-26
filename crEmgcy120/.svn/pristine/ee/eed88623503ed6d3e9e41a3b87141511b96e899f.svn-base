package com.emgcy120.core.common.inHosp.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>
 * 急救人员指派医院表
 * </p>
 *
 * @author chenshuzhuo
 * @since 2018-01-15
 */
@TableName("cr_emergency_org")
@ApiModel(value = "急救人员指派医院表类")
public class EmergencyOrg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value="id", type= IdType.AUTO)
    @ApiModelProperty(value = "主键ID",hidden=true)
	@JsonIgnore
	private Long id;
    /**
     * UUID
     */
    @ApiModelProperty(value = "UUID")
	private String uuid;
    /**
     * 医院id
     */
	@TableField("org_hospital_id")
    @ApiModelProperty(value = "医院id",hidden=true)
	private Long orgHospitalId;
	
	@TableField(exist=false)
	@ApiModelProperty(value = "医院uuid")
	@NotBlank(groups={Emgchange.class})
	@Length(min=32,max=32,message="长度不正确",groups={Emgchange.class})
	private String orgHospitalUuid;
    /**
     * 受理状态(-1:已取消,0:待受理,1:未受理,2:已受理,3:等待超时)
     */
    @ApiModelProperty(value = "受理状态(-1:已取消,0:待受理,1:未受理,2:已受理,3:等待超时)",hidden=true)
    @JsonIgnore
	private String state;
    /**
     * 状态时刻
     */
	@TableField("state_time")
    @ApiModelProperty(value = "状态时刻")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date stateTime;
    /**
     * 受理开始时间
     */
	@TableField("acceptance_start_time")
    @ApiModelProperty(value = "受理开始时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date acceptanceStartTime;
    /**
     * 受理结束时间
     */
	@TableField("acceptance_End_time")
    @ApiModelProperty(value = "受理结束时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date acceptanceEndTime;
    /**
     * 拒绝原因
     */
    @ApiModelProperty(value = "拒绝原因")
	private String reason;
    /**
     * 受理人id
     */
	@TableField("acceptance_id")
    @ApiModelProperty(value = "受理人id")
	private Long acceptanceId;
    /**
     * 120事件编号
     */
	@TableField("event_number")
    @ApiModelProperty(value = "事件编号")
	@NotBlank(groups= {Emgchange.class,Emgovertime.class})
	private String eventNumber;
    /**
     * 车辆数目
     */
	@TableField("vehicle_num")
    @ApiModelProperty(value = "车辆数目")
	@NotNull(groups=Emgchange.class)
	@Min(value = 1,groups=Emgchange.class)
	private Integer vehicleNum;
    /**
     * 派单人uuid
     */
	@TableField("singles_uuid")
    @ApiModelProperty(value = "派单人uuid")
	private String singlesUuid;
    /**
     * 派单人姓名
     */
	@TableField("singles_name")
    @ApiModelProperty(value = "派单人姓名")
	private String singlesName;
	
	@TableField(exist=false)
	@ApiModelProperty(value = "(再次调度,改派订单之前)的医院uuid")
	@NotBlank(groups={Emgchange.class})
	@Length(min=32,max=32,message="长度不正确",groups={Emgchange.class})
	private String beforeHospitalUuid;

	public interface Emgchange{};
	public interface Emgovertime{}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Long getOrgHospitalId() {
		return orgHospitalId;
	}
	public void setOrgHospitalId(Long orgHospitalId) {
		this.orgHospitalId = orgHospitalId;
	}
	public String getOrgHospitalUuid() {
		return orgHospitalUuid;
	}
	public void setOrgHospitalUuid(String orgHospitalUuid) {
		this.orgHospitalUuid = orgHospitalUuid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getStateTime() {
		return stateTime;
	}
	public void setStateTime(Date stateTime) {
		this.stateTime = stateTime;
	}
	public Date getAcceptanceStartTime() {
		return acceptanceStartTime;
	}
	public void setAcceptanceStartTime(Date acceptanceStartTime) {
		this.acceptanceStartTime = acceptanceStartTime;
	}
	public Date getAcceptanceEndTime() {
		return acceptanceEndTime;
	}
	public void setAcceptanceEndTime(Date acceptanceEndTime) {
		this.acceptanceEndTime = acceptanceEndTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Long getAcceptanceId() {
		return acceptanceId;
	}
	public void setAcceptanceId(Long acceptanceId) {
		this.acceptanceId = acceptanceId;
	}
	public String getEventNumber() {
		return eventNumber;
	}
	public void setEventNumber(String eventNumber) {
		this.eventNumber = eventNumber;
	}
	public Integer getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(Integer vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public String getSinglesUuid() {
		return singlesUuid;
	}
	public void setSinglesUuid(String singlesUuid) {
		this.singlesUuid = singlesUuid;
	}
	public String getSinglesName() {
		return singlesName;
	}
	public void setSinglesName(String singlesName) {
		this.singlesName = singlesName;
	}
	public String getBeforeHospitalUuid() {
		return beforeHospitalUuid;
	}
	public void setBeforeHospitalUuid(String beforeHospitalUuid) {
		this.beforeHospitalUuid = beforeHospitalUuid;
	}
	@Override
	public String toString() {
		return "EmergencyOrg [id=" + id + ", uuid=" + uuid + ", orgHospitalId=" + orgHospitalId + ", orgHospitalUuid="
				+ orgHospitalUuid + ", state=" + state + ", stateTime=" + stateTime + ", acceptanceStartTime="
				+ acceptanceStartTime + ", acceptanceEndTime=" + acceptanceEndTime + ", reason=" + reason
				+ ", acceptanceId=" + acceptanceId + ", eventNumber=" + eventNumber + ", vehicleNum=" + vehicleNum
				+ ", singlesUuid=" + singlesUuid + ", singlesName=" + singlesName + ", beforeHospitalUuid="
				+ beforeHospitalUuid + "]";
	}
	
	
}
