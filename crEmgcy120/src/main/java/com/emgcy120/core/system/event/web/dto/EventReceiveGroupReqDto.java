package com.emgcy120.core.system.event.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by weijieliao on 2017/11/16.
 */
@Data
public class EventReceiveGroupReqDto {

    //报案人姓名
    @ApiModelProperty( value = "报案人姓名" , required = true )
    @NotNull( message="报案人姓名不能为空" )
    private String reporter ;
    //报案人联系电话
    @ApiModelProperty( value = "报案人联系电话" , required = true )
    @NotNull( message="报案人联系电话不能为空" )
    private String phone ;
    //事故地址
    @ApiModelProperty( value = "事故地址" , required = true )
    @NotNull( message="事故地址不能为空" )
    private String place ;
    //乡镇
    @ApiModelProperty( value = "乡镇" , required = true )
    @NotNull( message="乡镇不能为空" )
    private Long region ;
    //事件等级（1、一般事件；2、较大事件；3、重大事件；4、特别重大事件）
    @ApiModelProperty( value = "事件等级（1、一般事件；2、较大事件；3、重大事件；4、特别重大事件）" , required = true )
    @Range( min=1 , max=4 , message="未知的事件等级" )
    private Integer accidentLevel ;
    //事件类型
    @ApiModelProperty( value = "事件类型" , required = true )
    private Integer accidentType ;
    //指派医院数量
    @ApiModelProperty( value = "指派医院数量" , required = true )
    @Min( value=1 , message="指派医院数量不能少于1" )
    private Integer hospNum ;
    //指派医院列表
//    @ApiModelProperty( value = "指派医院列表" , dataType = "com.emgcy120.core.system.event.web.dto.AssignBean" , required = true )
    @Valid
    private List<AssignBean> assignList ;
    //救援类型
    @ApiModelProperty( value = "救援类型" , required = true )
    @NotNull( message="救援类型不能为空" )
    private String rescueType ;
    //报案人描述
    @ApiModelProperty( value = "报案人描述" )
    private String reporterDesc ;
    //事件等级（1、一般事件；2、较大事件；3、重大事件；4、特别重大事件）
    @ApiModelProperty( value = "事件等级（1、一般事件；2、较大事件；3、重大事件；4、特别重大事件）" , required = true )
    @Range( min=1 , max=4 , message="错误的事件等级" )
    private Integer level ;

}
