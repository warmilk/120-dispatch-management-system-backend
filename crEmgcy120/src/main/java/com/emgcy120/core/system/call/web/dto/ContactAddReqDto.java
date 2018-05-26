package com.emgcy120.core.system.call.web.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by weijieliao on 2017/11/23.
 */
@Data
public class ContactAddReqDto {

    //联系号码
    @NotNull( message = "联系号码不能为空" )
    private String phoneNumber ;
    //单位名称
    @NotNull( message = "单位名称不能为空" )
    private String orgName ;
    //备注名（联系人）
    @NotNull( message = "联系人不能为空" )
    private String remarkName ;
//    //号码类型
//    private int phoneType ;

}
