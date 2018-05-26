package com.emgcy120.core.system.sys.entity;

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
 * @since 2017-11-15
 */
@Data
@TableName("sys_user_120")
public class User120 extends Model<User120> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * UUID
     */
	private String uuid;
    /**
     * 员工号
     */
	@TableField("employee_id")
	private String employeeId;
    /**
     * 姓名
     */
	private String name;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 盐
     */
	private String salt;
    /**
     * 性别：1男，2女
     */
	private Integer sex;
    /**
     * 生日
     */
	private Date birthday;
    /**
     * 手机号码
     */
	private String phone;
    /**
     * 身份证号
     */
	@TableField("id_card")
	private String idCard;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 地址
     */
	private String address;
    /**
     * 头像照片
     */
	private String photo;
    /**
     * 个人签名
     */
	private String signature;
    /**
     * 职称
     */
	@TableField("job_title")
	private String jobTitle;
    /**
     * 职务（字典数据）
     */
	@TableField("user_type")
	private Long userType;
    /**
     * 使用状态：-1停用，0未激活，1可用
     */
	private Integer status;
    /**
     * 注册时间
     */
	@TableField("register_time")
	private Date registerTime;
    /**
     * 上次登录时间
     */
	@TableField("login_time")
	private Date loginTime;
    /**
     * 上次登录IP
     */
	@TableField("login_ip")
	private String loginIp;
    /**
     * 是否在线：0不在线，1在线
     */
	private Integer online;
	/**
     * 是否是初始密码：0、不是，1、是
     */
	@TableField("initial_pwd")
	private Integer initialPwd;
    /**
     * 创建人
     */
	private Long creator;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 修改人
     */
	private Long modifier;
    /**
     * 修改时间
     */
	@TableField("modify_time")
	private Date modifyTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
