package com.emgcy120.core.system.event.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-16
 */
@TableName("cr_common_emgcy_120")
public class CommonEmgcy120 extends Model<CommonEmgcy120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 患者姓名（普通急救特有）
     */
	@TableField("patient_name")
	private String patientName;
    /**
     * 患者性别（1、男；2、女；3、其他）（普通急救特有）
     */
	@TableField("patient_sex")
	private Integer patientSex;
    /**
     * 患者年龄（普通急救特有）
     */
	@TableField("patient_age")
	private Integer patientAge;
    /**
     * 患者身份（1、普通；2、三无；3、其他）（普通急救特有）
     */
	@TableField("patient_identity")
	private Integer patientIdentity;
    /**
     * 报案人代诉（普通急救特有）
     */
	@TableField("reporter_desc")
	private String reporterDesc;
    /**
     * 患者主诉（普通急救特有）
     */
	@TableField("patient_desc")
	private String patientDesc;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(Integer patientSex) {
		this.patientSex = patientSex;
	}

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}

	public Integer getPatientIdentity() {
		return patientIdentity;
	}

	public void setPatientIdentity(Integer patientIdentity) {
		this.patientIdentity = patientIdentity;
	}

	public String getReporterDesc() {
		return reporterDesc;
	}

	public void setReporterDesc(String reporterDesc) {
		this.reporterDesc = reporterDesc;
	}

	public String getPatientDesc() {
		return patientDesc;
	}

	public void setPatientDesc(String patientDesc) {
		this.patientDesc = patientDesc;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CommonEmgcy120{" +
			"id=" + id +
			", patientName=" + patientName +
			", patientSex=" + patientSex +
			", patientAge=" + patientAge +
			", patientIdentity=" + patientIdentity +
			", reporterDesc=" + reporterDesc +
			", patientDesc=" + patientDesc +
			"}";
	}
}
