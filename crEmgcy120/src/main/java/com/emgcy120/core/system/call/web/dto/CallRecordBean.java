package com.emgcy120.core.system.call.web.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by weijieliao on 2017/11/21.
 */
@Data
public class CallRecordBean {

    //通话记录id
    private String callRecordId ;
    //电话号码
    private String phoneNumber ;
    //归属地
    private String ascription ;
    //是否已接听
    private boolean hadConnected ;
    //通话时长，单位秒
    private int talkTime ;
    //通话时间
    private Date callTime ;
    //接通时间
    private Date connectTime ;
    //结束通话时间
    private Date endTime ;
    //备注名称
    private String remarkName;
    //接听者工号
    private String employeeId ;
    //响铃次数
    private int bellCount ;

}
