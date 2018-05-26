package com.emgcy120.core.system.sys.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by weijieliao on 2017/12/19.
 */
@ApiModel
@Data
public class PwdApplyApplyReqDto {

    //登录账户
    @ApiModelProperty( value = "登录账户" )
    @NotBlank( message = "登录账户不能为空" )
    private String email ;
    //手机号
    @ApiModelProperty( value = "手机号" )
    @NotBlank( message = "手机号不能为空" )
    private String phone ;
    //姓名
    @ApiModelProperty( value = "姓名" )
    @NotBlank( message = "姓名不能为空" )
    private String name ;
    //坐席工号
    @ApiModelProperty( value = "坐席工号" )
    @NotBlank( message = "坐席工号不能为空" )
    private String employeeId ;

}
