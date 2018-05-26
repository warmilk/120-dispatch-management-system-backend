package com.emgcy120.core.system.staff.web.dto;

import com.emgcy120.core.system.base.BasePageReqDto;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * Created by weijieliao on 2017/12/6.
 */
@Data
public class StaffListReqDto extends BasePageReqDto{

    //医院id
    @Min( value = 1 , message = "医院id不存在" )
    private long hospId ;
    //姓名
    private String name ;
    //性别（0、全部，1、男，2、女）
    private int sex ;
    //电话
    private String phone ;
    //科室
    private String department ;
    //职务
    private String position ;

}
