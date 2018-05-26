package com.emgcy120.core.system.sys.entity;

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

/**
 * <p>
 * 
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-15
 */
@TableName("cr_pwd_apply_120")
public class PwdApply120 extends Model<PwdApply120> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "email")
	private String email;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "phone")
	private String phone;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "name")
	private String name;
    /**
     * 工号
     */
	@TableField("employee_id")
    @ApiModelProperty(value = "employee_id")
	private String employeeId;
    /**
     * 处理结果：1.已回复初始密码，2.已忽略申请，3、未处理
     */
	@TableField("process_result")
    @ApiModelProperty(value = "process_result")
	private Integer processResult;
    /**
     * 校验结果：0、错误，1、正确
     */
	@TableField("check_result")
    @ApiModelProperty(value = "check_result")
	private Integer checkResult;
    /**
     * 申请时间
     */
	@TableField("apply_time")
    @ApiModelProperty(value = "apply_time")
	private Date applyTime;
    /**
     * 处理时间
     */
	@TableField("process_time")
    @ApiModelProperty(value = "process_time")
	private Date processTime;
    /**
     * 邮箱验证结果：0、错误，1、正确
     */
	@TableField("check_email")
    @ApiModelProperty(value = "check_email")
	private Integer checkEmail;
    /**
     * 联系号码验证结果：0、错误，1、正确
     */
	@TableField("check_phone")
    @ApiModelProperty(value = "check_phone")
	private Integer checkPhone;
    /**
     * 姓名验证结果：0、错误，1、正确
     */
	@TableField("check_name")
    @ApiModelProperty(value = "check_name")
	private Integer checkName;
    /**
     * 员工号验证结果：0、错误，1、正确
     */
	@TableField("check_employee_id")
    @ApiModelProperty(value = "check_employee_id")
	private Integer checkEmployeeId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getProcessResult() {
		return processResult;
	}

	public void setProcessResult(Integer processResult) {
		this.processResult = processResult;
	}

	public Integer getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(Integer checkResult) {
		this.checkResult = checkResult;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getProcessTime() {
		return processTime;
	}

	public void setProcessTime(Date processTime) {
		this.processTime = processTime;
	}

    public Integer getCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(Integer checkEmail) {
        this.checkEmail = checkEmail;
    }

    public Integer getCheckPhone() {
        return checkPhone;
    }

    public void setCheckPhone(Integer checkPhone) {
        this.checkPhone = checkPhone;
    }

    public Integer getCheckName() {
        return checkName;
    }

    public void setCheckName(Integer checkName) {
        this.checkName = checkName;
    }

    public Integer getCheckEmployeeId() {
        return checkEmployeeId;
    }

    public void setCheckEmployeeId(Integer checkEmployeeId) {
        this.checkEmployeeId = checkEmployeeId;
    }

    @Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PwdApply120{" +
			"id=" + id +
			", email=" + email +
			", phone=" + phone +
			", name=" + name +
			", employeeId=" + employeeId +
			", processResult=" + processResult +
			", checkResult=" + checkResult +
			", applyTime=" + applyTime +
			", processTime=" + processTime +
			", checkEmail=" + checkEmail +
			", checkPhone=" + checkPhone +
			", checkName=" + checkName +
			", checkEmployeeId=" + checkEmployeeId +
			"}";
	}
}
