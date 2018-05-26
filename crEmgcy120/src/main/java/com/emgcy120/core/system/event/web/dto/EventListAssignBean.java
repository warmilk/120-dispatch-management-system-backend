package com.emgcy120.core.system.event.web.dto;

import lombok.Data;

/**
 * Created by weijieliao on 2017/12/1.
 */
@Data
public class EventListAssignBean {

    //医院
    private String hospital ;
    //受理状态
    private int receiveStatus ;
    //受理人
    private String receiver ;

}
