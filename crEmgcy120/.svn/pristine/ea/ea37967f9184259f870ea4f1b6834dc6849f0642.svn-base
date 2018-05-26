package com.emgcy120.core.system.org.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 机构表
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-28
 */
@TableName("sys_org")
public class Org extends Model<Org> {

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
     * 父级ID
     */
	@TableField("parent_id")
    @ApiModelProperty(value = "parent_id")
	private Long parentId;
    /**
     * 编码
     */
    @ApiModelProperty(value = "code")
	private String code;
    /**
     * 机构名称
     */
    @ApiModelProperty(value = "name")
	private String name;
    /**
     * 类型：1医院，2一级科室，3二级科室
     */
    @ApiModelProperty(value = "type")
	private Integer type;
    /**
     * 描述
     */
    @ApiModelProperty(value = "description")
	private String description;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "telephone")
	private String telephone;
    /**
     * 地址
     */
    @ApiModelProperty(value = "address")
	private String address;
    /**
     * 网站
     */
    @ApiModelProperty(value = "website")
	private String website;
    /**
     * logo图
     */
    @ApiModelProperty(value = "logo")
	private String logo;
    /**
     * 医院等级（字典数据）
     */
    @ApiModelProperty(value = "level")
	private Long level;
    /**
     * 医院类型（字典数据）
     */
	@TableField("hospital_type")
    @ApiModelProperty(value = "hospital_type")
	private Long hospitalType;
    /**
     * 经度
     */
    @ApiModelProperty(value = "longitude")
	private Double longitude;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "latitude")
	private Double latitude;
    /**
     * 排序
     */
	@TableField("order_num")
    @ApiModelProperty(value = "order_num")
	private Integer orderNum;
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
    /**
     * 是否删除：-1已删除，0正常
     */
	@TableField("del_flag")
    @TableLogic
    @ApiModelProperty(value = "del_flag")
	private Integer delFlag;
    /**
     * 备注
     */
    @ApiModelProperty(value = "remark")
	private String remark;


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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public Long getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(Long hospitalType) {
		this.hospitalType = hospitalType;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
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

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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
		return "Org{" +
			"id=" + id +
			", uuid=" + uuid +
			", parentId=" + parentId +
			", code=" + code +
			", name=" + name +
			", type=" + type +
			", description=" + description +
			", telephone=" + telephone +
			", address=" + address +
			", website=" + website +
			", logo=" + logo +
			", level=" + level +
			", hospitalType=" + hospitalType +
			", longitude=" + longitude +
			", latitude=" + latitude +
			", orderNum=" + orderNum +
			", createBy=" + createBy +
			", createTime=" + createTime +
			", updateBy=" + updateBy +
			", updateTime=" + updateTime +
			", delFlag=" + delFlag +
			", remark=" + remark +
			"}";
	}
}
