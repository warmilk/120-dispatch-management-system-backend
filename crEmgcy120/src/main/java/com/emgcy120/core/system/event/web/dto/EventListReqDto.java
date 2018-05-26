package com.emgcy120.core.system.event.web.dto;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.system.base.BasePageReqDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * Created by weijieliao on 2017/11/29.
 */
@Data
public class EventListReqDto extends BasePageReqDto {

    //操作员
    @ApiModelProperty( value = "操作员" , required = true )
    private String operator ;
    //受理开始时间
    @ApiModelProperty( value = "受理开始时间" , required = true )
    private Long startTime ;
    //受理结束时间
    @ApiModelProperty( value = "受理结束时间" , required = true )
    private Long endTime ;
    //受理状态
    @ApiModelProperty( value = "受理状态" , required = true )
    private Integer receiveStatus ;
    //指派医院
    @ApiModelProperty( value = "指派医院" , required = true )
    private String hospital ;
    //事件类型（1、普通;2、群体）
    @ApiModelProperty( value = "事件类型（1、普通;2、群体）" , required = true )
    private Integer eventType ;
    //患者身份（1、普通；2、三无；3、其他）
    @ApiModelProperty( value = "患者身份（1、普通；2、三无；3、其他）" , required = true )
    private Integer patientIdentity ;
    //报案电话
    @ApiModelProperty( value = "报案电话" , required = true )
    private String reportPhone ;

}
