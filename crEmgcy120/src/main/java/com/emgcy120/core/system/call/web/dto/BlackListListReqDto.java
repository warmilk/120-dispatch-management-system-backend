package com.emgcy120.core.system.call.web.dto;

import com.emgcy120.core.system.base.BasePageReqDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by weijieliao on 2017/11/23.
 */
@ApiModel
@Data
public class BlackListListReqDto extends BasePageReqDto {

    //通话日期
    @ApiModelProperty( value = "通话日期" )
    private String callDate ;
    //手机号码
    @ApiModelProperty( value = "手机号码" )
    private String phoneNumber ;
    //坐席工号
    @ApiModelProperty( value = "坐席工号" )
    private String employeeId ;

}
