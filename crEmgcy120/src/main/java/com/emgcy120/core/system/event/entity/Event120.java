package com.emgcy120.core.system.event.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("cr_event_120")
public class Event120 extends Model<Event120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
	@TableId(value="id")
	private String id;
    /**
     * 报案人
     */
	private String reporter;
    /**
     * 联系电话
     */
	private String phone;
    /**
     * 事件类型（1、普通;2、群体）
     */
	@TableField("event_type")
	private Integer eventType;
    /**
     * 乡镇、管辖区，参照字电表中的region
     */
	private Long region;
	/**
     * 地址
     */
	private String place;
    /**
     * 救援类型
     */
	@TableField("rescue_type")
	private String rescueType;
    /**
     * 危重等级（1、清醒；2、意识不清；3、昏迷；4、死亡）
     */
	private Integer level;
    /**
     * 操作员
     */
	@TableField("operator_id")
	private Long operatorId;
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
	/**
	 * 事件等级（1、一般事件；2、较大事件；3、重大事件；4、特别重大事件）（群体事件特有）
	 */
	@TableField("accident_level")
	private Integer accidentLevel;
	/**
	 * 事故类型（群体事件特有）
	 */
	@TableField("accident_type")
	private Integer accidentType;
    /**
     * 新建时间
     */
	@TableField("create_time")
	private Date createTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
