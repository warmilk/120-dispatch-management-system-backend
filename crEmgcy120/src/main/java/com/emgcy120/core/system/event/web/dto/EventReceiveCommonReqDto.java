package com.emgcy120.core.system.event.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

/**
 * Created by weijieliao on 2017/11/16.
 */
@ApiModel
@Data
public class EventReceiveCommonReqDto {

    //患者姓名
    @ApiModelProperty( value = "患者姓名" , required = true )
    @NotBlank( message="患者姓名不能为空" )
    private String patientName ;
    //患者性别（1、男；2、女；3、其他）
    @ApiModelProperty( value = "患者性别（1、男；2、女；3、其他）" , required = true )
    @Range( min=1 , max=3 , message="性别错误" )
    private Integer patientSex ;
    //年龄
    @ApiModelProperty( value = "年龄" , required = true )
    @Min( value=0 , message="年龄不能小于0" )
    private Integer patientAge ;
    //患者身份（1、普通；2、三无；3、其他）
    @ApiModelProperty( value = "患者身份（1、普通；2、三无；3、其他）" , required = true )
    @Range( min=1 , max=3 , message="患者身份错误" )
    private Integer patientIdentity ;
    //报案人姓名
    @ApiModelProperty( value = "报案人姓名" , required = true )
    @NotBlank( message="报案人姓名不能为空" )
    private String reporter ;
    //报案人联系电话
    @ApiModelProperty( value = "报案人联系电话" , required = true )
    @NotBlank( message="报案人联系电话不能为空" )
    private String phone ;
    //乡镇
    @ApiModelProperty( value = "乡镇" , required = true )
    @NotNull( message="乡镇不能为空" )
    private Long region ;
    //事故地址
    @ApiModelProperty( value = "事故地址" , required = true )
    @NotBlank( message="事故地址不能为空" )
    private String place ;
    //指派医院
    @ApiModelProperty( value = "指派医院" , required = true )
    @NotNull( message="指派医院不能为空" )
    private Long hospId ;
    //指派车辆数量
    @ApiModelProperty( value = "指派车辆数量" , required = true )
    @Min( value=0 , message="指派车辆数量不能小于0" )
    private int carNum ;
    //救援类型
    @ApiModelProperty( value = "救援类型" , required = true )
    @NotBlank( message="救援类型不能为空" )
    private String rescueType ;
    //报案人代诉
    @ApiModelProperty( value = "报案人代诉" )
    private String reporterDesc ;
    //患者主诉
    @ApiModelProperty( value = "患者主诉" )
    private String patientDesc ;
    //危重等级
    @ApiModelProperty( value = "危重等级" , required = true )
    @Range( min=1 , max=4 , message="未知的危重等级" )
    private Integer level ;

}
