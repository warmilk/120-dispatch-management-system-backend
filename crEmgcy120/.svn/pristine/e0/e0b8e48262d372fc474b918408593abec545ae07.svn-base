package com.emgcy120.core.system.event.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by weijieliao on 2017/11/17.
 */
@ApiModel
@Data
public class AssignBean {

    //指派医院
    @ApiModelProperty( value = "指派医院" , required = true )
    @NotNull( message="指派医院不能为空" )
    private Long hospId ;
    //指派车辆数量
    @ApiModelProperty( value = "指派车辆数量" , required = true )
    @Min( value=0 , message="指派车辆数量不能小于0" )
    private int carNum ;

}
