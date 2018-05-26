package com.emgcy120.core.system.attachment.entity;

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
 * 120调度中心附件表
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-26
 */
@TableName("cr_attachment_120")
public class Attachment120 extends Model<Attachment120> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
    @ApiModelProperty(value = "id")
	private Long id;
    /**
     * 文件名称
     */
	@TableField("file_name")
    @ApiModelProperty(value = "file_name")
	private String fileName;
    /**
     * 附件项类型(1:文档,2:压缩文件,3:图片,4:语音文件,5:视频文件,0:未知)
     */
	@TableField("file_type")
    @ApiModelProperty(value = "file_type")
	private Integer fileType;
    /**
     * 路径
     */
    @ApiModelProperty(value = "path")
	private String path;
    /**
     * MD5散列值
     */
    @ApiModelProperty(value = "md5")
	private String md5;
    /**
     * 文件大小
     */
    @ApiModelProperty(value = "size")
	private Long size;
	/**
     * 下载地址
     */
    @ApiModelProperty(value = "download_url")
	private String downloadUrl ;
    /**
     * 创建者
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
	@TableField("modify_by")
    @ApiModelProperty(value = "modify_by")
	private Long modifyBy;
    /**
     * 修改时间
     */
	@TableField("modify_time")
    @ApiModelProperty(value = "modify_time")
	private Date modifyTime;
    /**
     * 是否可用：0、不可用，1、可用
     */
    @ApiModelProperty(value = "enable")
	private Integer enable;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
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

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
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
		return "Attachment120{" +
			"id=" + id +
			", fileName=" + fileName +
			", fileType=" + fileType +
			", path=" + path +
			", md5=" + md5 +
			", size=" + size +
			", downloadUrl=" + downloadUrl +
			", createBy=" + createBy +
			", createTime=" + createTime +
			", modifyBy=" + modifyBy +
			", modifyTime=" + modifyTime +
			", enable=" + enable +
			", remark=" + remark +
			"}";
	}
}
