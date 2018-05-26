package com.emgcy120.core.system.call.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by weijieliao on 2017/11/24.
 */
@ApiModel
@Data
public class BlackListAddReqDto {

    //手机号码
    @ApiModelProperty( value = "手机号码" )
    @NotNull( message="手机号码不能为空" )
    private String phoneNumber ;

}
