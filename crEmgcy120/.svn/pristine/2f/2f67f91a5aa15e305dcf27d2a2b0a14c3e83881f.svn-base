package com.emgcy120.core.system.staff.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-06
 */
@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
	@TableId(value="id", type= IdType.AUTO)
    @ApiModelProperty(value = "id")
	private Long id;
    /**
     * UUID
     */
    @ApiModelProperty(value = "uuid")
	private String uuid;
    /**
     * 医院机构ID
     */
	@TableField("org_hospital_id")
    @ApiModelProperty(value = "org_hospital_id")
	private Long orgHospitalId;
    /**
     * 科室机构ID
     */
	@TableField("org_dept_id")
    @ApiModelProperty(value = "org_dept_id")
	private Long orgDeptId;
    /**
     * 员工号
     */
	@TableField("employee_id")
    @ApiModelProperty(value = "employee_id")
	private String employeeId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "name")
	private String name;
    /**
     * 用户名
     */
	@TableField("user_name")
    @ApiModelProperty(value = "user_name")
	private String userName;
    /**
     * 电子签名密码
     */
	@TableField("sign_password")
    @ApiModelProperty(value = "sign_password")
	private String signPassword;
    /**
     * 密码
     */
    @ApiModelProperty(value = "password")
	private String password;
    /**
     * 盐
     */
    @ApiModelProperty(value = "salt")
	private String salt;
    /**
     * 性别：1男，2女
     */
    @ApiModelProperty(value = "sex")
	private Integer sex;
    /**
     * 生日
     */
    @ApiModelProperty(value = "birthday")
	private Date birthday;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "phone")
	private String phone;
    /**
     * 身份证号
     */
	@TableField("id_card")
    @ApiModelProperty(value = "id_card")
	private String idCard;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "email")
	private String email;
    /**
     * 地址
     */
    @ApiModelProperty(value = "address")
	private String address;
    /**
     * 头像照片
     */
    @ApiModelProperty(value = "photo")
	private String photo;
    /**
     * 个人签名
     */
    @ApiModelProperty(value = "signature")
	private String signature;
    /**
     * 职称
     */
	@TableField("job_title")
    @ApiModelProperty(value = "job_title")
	private String jobTitle;
    /**
     * 职务
     */
    @ApiModelProperty(value = "position")
	private String position;
    /**
     * 用户类型：1院内后台，2院内前台，3院内前后台，4其他
     */
	@TableField("user_type")
    @ApiModelProperty(value = "user_type")
	private Integer userType;
    /**
     * 擅长
     */
    @ApiModelProperty(value = "major")
	private String major;
    /**
     * 简介
     */
    @ApiModelProperty(value = "summary")
	private String summary;
    /**
     * 使用状态：-1停用，0未激活，1可用
     */
    @ApiModelProperty(value = "status")
	private Integer status;
    /**
     * 注册时间
     */
	@TableField("register_time")
    @ApiModelProperty(value = "register_time")
	private Date registerTime;
    /**
     * 上次登录时间
     */
	@TableField("login_time")
    @ApiModelProperty(value = "login_time")
	private Date loginTime;
    /**
     * 上次登录IP
     */
	@TableField("login_ip")
    @ApiModelProperty(value = "login_ip")
	private String loginIp;
    /**
     * 是否在线：0不在线，1在线
     */
    @ApiModelProperty(value = "online")
	private Integer online;
    /**
     * 是否为专家：0否，1是
     */
    @ApiModelProperty(value = "expert")
	private Integer expert;
    /**
     * 创建人
     */
	@TableField("create_by")
    @ApiModelProperty(value = "create_by")
	private Long createBy;
    /**
     * 创建时间
     */
	@TableField("create_time")
    @ApiModelProperty(value = "create_time")
	private Date createTime;
    /**
     * 修改人
     */
	@TableField("update_by")
    @ApiModelProperty(value = "update_by")
	private Long updateBy;
    /**
     * 修改时间
     */
	@TableField("update_time")
    @ApiModelProperty(value = "update_time")
	private Date updateTime;


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

	public Long getOrgDeptId() {
		return orgDeptId;
	}

	public void setOrgDeptId(Long orgDeptId) {
		this.orgDeptId = orgDeptId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSignPassword() {
		return signPassword;
	}

	public void setSignPassword(String signPassword) {
		this.signPassword = signPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Integer getExpert() {
		return expert;
	}

	public void setExpert(Integer expert) {
		this.expert = expert;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", uuid=" + uuid +
			", orgHospitalId=" + orgHospitalId +
			", orgDeptId=" + orgDeptId +
			", employeeId=" + employeeId +
			", name=" + name +
			", userName=" + userName +
			", signPassword=" + signPassword +
			", password=" + password +
			", salt=" + salt +
			", sex=" + sex +
			", birthday=" + birthday +
			", phone=" + phone +
			", idCard=" + idCard +
			", email=" + email +
			", address=" + address +
			", photo=" + photo +
			", signature=" + signature +
			", jobTitle=" + jobTitle +
			", position=" + position +
			", userType=" + userType +
			", major=" + major +
			", summary=" + summary +
			", status=" + status +
			", registerTime=" + registerTime +
			", loginTime=" + loginTime +
			", loginIp=" + loginIp +
			", online=" + online +
			", expert=" + expert +
			", createBy=" + createBy +
			", createTime=" + createTime +
			", updateBy=" + updateBy +
			", updateTime=" + updateTime +
			"}";
	}
}
