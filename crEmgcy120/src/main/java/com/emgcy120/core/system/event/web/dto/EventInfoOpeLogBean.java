package com.emgcy120.core.system.event.web.dto;

import com.emgcy120.core.system.event.entity.EventOperationLog120;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by weijieliao on 2017/12/5.
 */
@Data
public class EventInfoOpeLogBean {

    private static final SimpleDateFormat SDF = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ) ;

    private String eventOpeLogId ;
    //操作时间
    private String opeTime ;
    //操作员
    private String operator;
    //操作类型
    private String opeType;
    //备注
    private String remark;

//    public void byMap( Map map ) {
//
//        setEventOpeLogId( ( String )map.get( "eventOpeLogId" ) ) ;
//        setOpeTime( ( String )map.get( "opeTime" ) ) ;
//        setOperator( ( String )map.get( "operator" ) ) ;
//        setOpeType( ( String )map.get( "opeType" ) ) ;
//        setRemark( ( String )map.get( "remark" ) ) ;
//
//    }
    
}
