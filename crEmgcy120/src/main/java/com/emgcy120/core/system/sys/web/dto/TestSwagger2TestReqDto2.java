package com.emgcy120.core.system.sys.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by weijieliao on 2018/1/16.
 */
@ApiModel
@Data
public class TestSwagger2TestReqDto2 {

    @ApiModelProperty( value = "value1" , name = "name1" )
    private String param01 ;
    private String param02 ;

}
