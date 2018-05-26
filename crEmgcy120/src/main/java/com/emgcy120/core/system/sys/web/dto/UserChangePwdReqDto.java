package com.emgcy120.core.system.sys.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by weijieliao on 2017/12/19.
 */
@ApiModel
@Data
public class UserChangePwdReqDto {

    //旧密码
    @ApiModelProperty( value = "旧密码" )
    @NotNull( message = "旧密码不能为空" )
    private String oldPassword ;
    //新密码
    @ApiModelProperty( value = "新密码" )
    @NotNull( message = "新密码不能为空" )
    private String newPassword ;

}
