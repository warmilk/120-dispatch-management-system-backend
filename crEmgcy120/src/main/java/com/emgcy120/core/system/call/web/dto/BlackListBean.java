package com.emgcy120.core.system.call.web.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by weijieliao on 2017/11/23.
 */
@Data
public class BlackListBean {

    //黑名单id
    private long blackListId ;
    //操作员工号
    private String employeeId ;
    //号码
    private String phoneNumber ;
    //通话次数
    private int callCount ;
    //最后通话时间
    private Date lastTime ;
    //归属地
    private String ascription ;

}
