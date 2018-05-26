package com.emgcy120.core.system.event.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-16
 */
@TableName("cr_group_emgcy_120")
public class GroupEmgcy120 extends Model<GroupEmgcy120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
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
     * 报案人描述
     */
	@TableField("reporter_desc")
	private String reporterDesc;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAccidentLevel() {
		return accidentLevel;
	}

	public void setAccidentLevel(Integer accidentLevel) {
		this.accidentLevel = accidentLevel;
	}

	public Integer getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(Integer accidentType) {
		this.accidentType = accidentType;
	}

	public String getReporterDesc() {
		return reporterDesc;
	}

	public void setReporterDesc(String reporterDesc) {
		this.reporterDesc = reporterDesc;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "GroupEmgcy120{" +
			"id=" + id +
			", accidentLevel=" + accidentLevel +
			", accidentType=" + accidentType +
			", reporterDesc=" + reporterDesc +
			"}";
	}
}
