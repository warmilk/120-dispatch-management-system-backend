package com.emgcy120.core.common.inHosp.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 急救人员表
 * </p>
 *
 * @author chenshuzhuo
 * @since 2018-01-15
 */
@TableName("cr_emergency")
@ApiModel(value = "急救人员表类")
public class Emergency extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	@TableId(value="id", type= IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
	private Long id;
    /**
     * uuid
     */
    @ApiModelProperty(value = "uuid")
	private String uuid;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
	private String name;
    /**
     * 身份(0:普通,1:三无病人,2:其他)
     */
    @ApiModelProperty(value = "身份(0:普通,1:三无病人,2:其他)")
	private String identity;
    /**
     * 性别(0:未知,1:男,2:女)
     */
    @ApiModelProperty(value = "性别(0:未知,1:男,2:女)")
	private String sex;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
	private Integer age;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
	private String address;
    /**
     * 救援类型
     */
	@TableField("rescue_type")
    @ApiModelProperty(value = "救援类型")
	private String rescueType;
    /**
     * 籍贯
     */
	@TableField("native_place")
    @ApiModelProperty(value = "籍贯")
	private String nativePlace;
    /**
     * 联系人姓名
     */
	@TableField("contact_name")
    @ApiModelProperty(value = "联系人姓名")
	private String contactName;
    /**
     * 联系人电话
     */
	@TableField("contact_phone")
    @ApiModelProperty(value = "联系人电话")
	private String contactPhone;
    /**
     * 报案人描述
     */
	@TableField("informant_desc")
    @ApiModelProperty(value = "报案人描述")
	private String informantDesc;
    /**
     * 患者主诉
     */
	@TableField("patient_desc")
    @ApiModelProperty(value = "患者主诉")
	private String patientDesc;
    /**
     * 既往史
     */
	@TableField("past_history")
    @ApiModelProperty(value = "既往史")
	private String pastHistory;
    /**
     * 危重等级(1:清醒,2:意识不清,3:昏迷,4:死亡)
     */
    @ApiModelProperty(value = "危重等级(1:清醒,2:意识不清,3:昏迷,4:死亡)")
	private String critical;
    /**
     * 指派医院车辆uuid
     */
	@TableField("org_vehicle_uuid")
    @ApiModelProperty(value = "指派医院车辆uuid")
	private String orgVehicleUuid;
    /**
     * 事件等级(0:普通事件,大于0为群体事件,1:一般,2:较大,3:重大,4:特大)
     */
    @ApiModelProperty(value = "事件等级(0:普通事件,大于0为群体事件,1:一般,2:较大,3:重大,4:特大)")
	private String grade;
    /**
     * 事件类型(0:普通事件,大于0为群体事件,值对应字典表)
     */
    @ApiModelProperty(value = "事件类型(0:普通事件,大于0为群体事件,值对应字典表)")
	private Long type;
    
    @ApiModelProperty(value = "保存 医院uuid,车辆数量")
    @TableField(exist=false)
    private List<EmergencyOrg> list;
    
    @ApiModelProperty(value = "增派车辆数量")
    @TableField(exist=false)
    private Integer addMoreNum;
    
    @ApiModelProperty(value = "呼叫时间")
    private Date callTime;
    

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRescueType() {
		return rescueType;
	}

	public void setRescueType(String rescueType) {
		this.rescueType = rescueType;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getInformantDesc() {
		return informantDesc;
	}

	public void setInformantDesc(String informantDesc) {
		this.informantDesc = informantDesc;
	}

	public String getPatientDesc() {
		return patientDesc;
	}

	public void setPatientDesc(String patientDesc) {
		this.patientDesc = patientDesc;
	}

	public String getPastHistory() {
		return pastHistory;
	}

	public void setPastHistory(String pastHistory) {
		this.pastHistory = pastHistory;
	}

	public String getCritical() {
		return critical;
	}

	public void setCritical(String critical) {
		this.critical = critical;
	}

	public String getOrgVehicleUuid() {
		return orgVehicleUuid;
	}

	public void setOrgVehicleUuid(String orgVehicleUuid) {
		this.orgVehicleUuid = orgVehicleUuid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public List<EmergencyOrg> getList() {
		return list;
	}

	public void setList(List<EmergencyOrg> list) {
		this.list = list;
	}

	public Integer getAddMoreNum() {
		return addMoreNum;
	}

	public void setAddMoreNum(Integer addMoreNum) {
		this.addMoreNum = addMoreNum;
	}
	

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}

	@Override
	public String toString() {
		return "Emergency [id=" + id + ", uuid=" + uuid + ", name=" + name + ", identity=" + identity + ", sex=" + sex
				+ ", age=" + age + ", address=" + address + ", rescueType=" + rescueType + ", nativePlace="
				+ nativePlace + ", contactName=" + contactName + ", contactPhone=" + contactPhone + ", informantDesc="
				+ informantDesc + ", patientDesc=" + patientDesc + ", pastHistory=" + pastHistory + ", critical="
				+ critical + ", orgVehicleUuid=" + orgVehicleUuid + ", grade=" + grade + ", type=" + type + ", list="
				+ list + ", addMoreNum=" + addMoreNum + "]";
	}

	

}
