package com.emgcy120.core.system.call.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by weijieliao on 2017/11/21.
 */
@Data
public class CallRecordAddReqDto {

    //通话号码
    @ApiModelProperty( value = "通话号码" )
    @NotNull( message="通话号码不能为空" )
    private String phoneNumber ;
    //归属地
    @ApiModelProperty( value = "归属地" )
    @NotNull( message="归属地不能为空" )
    private String ascription ;
    //类型（1、手机；2、固话）
    @ApiModelProperty( value = "类型（1、手机；2、固话）" )
    private int phoneType ;
    //呼叫类型（1、呼入；2、呼出）
    @ApiModelProperty( value = "呼叫类型（1、呼入；2、呼出）" )
    private int callType ;
    //呼叫时间
    @ApiModelProperty( value = "呼叫时间" )
    private long callTime ;
    //接通时间
    @ApiModelProperty( value = "接通时间" )
    private long connectTime ;
    //通话结束时间
    @ApiModelProperty( value = "通话结束时间" )
    private long endTime ;
    //通话时长，单位秒
    @ApiModelProperty( value = "通话时长，单位秒" )
    private int talkTime ;
    //是否已接听（1、已接听；2、未接听）
    @ApiModelProperty( value = "是否已接听（1、已接听；2、未接听）" )
    private int hadConnected ;
    //响铃次数
    @ApiModelProperty( value = "响铃次数" )
    private int bellCount ;

}
