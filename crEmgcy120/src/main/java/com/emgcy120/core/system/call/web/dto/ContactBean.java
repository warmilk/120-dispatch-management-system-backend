package com.emgcy120.core.system.call.web.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by weijieliao on 2017/11/23.
 */
@Data
public class ContactBean {

    //联系人id
    private long contactId ;
    //单位名称
    private String orgName ;
    //备注名称
    private String remarkName ;
    //联系号码
    private String phoneNumber ;
    //新建时间
    private Date createTime ;

}
