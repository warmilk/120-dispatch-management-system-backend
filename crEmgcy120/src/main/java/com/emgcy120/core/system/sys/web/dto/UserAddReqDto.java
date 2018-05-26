package com.emgcy120.core.system.sys.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by weijieliao on 2017/12/13.
 */
@ApiModel
@Data
public class UserAddReqDto {

    //电子邮箱
    @ApiModelProperty( value = "电子邮箱" )
    @Email( message="电子邮箱格式错误" )
    @NotNull( message = "电子邮箱不能为空" )
    private String email ;
    //密码
    @ApiModelProperty( value = "密码" )
    @NotNull( message = "密码不能为空" )
    private String password ;
    //姓名
    @ApiModelProperty( value = "姓名" )
    @NotNull( message = "姓名不能为空" )
    private String name ;
    //电话号码
    @ApiModelProperty( value = "电话号码" )
    @NotNull( message = "电话号码不能为空" )
    private String phone ;
    //头像url
    @ApiModelProperty( value = "头像url" )
    @NotBlank( message = "头像url不能为空" )
    private String photo ;
    //状态
    @ApiModelProperty( value = "状态" )
    private int status ;

}
