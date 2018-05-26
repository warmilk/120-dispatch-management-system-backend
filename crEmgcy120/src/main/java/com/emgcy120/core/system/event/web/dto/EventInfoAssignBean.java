package com.emgcy120.core.system.event.web.dto;

import com.emgcy120.core.common.util.BeanUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by weijieliao on 2017/12/1.
 */
@Data
public class EventInfoAssignBean {

    //指派id
    private long assignId ;
    //医院名称
    private String hospName ;
    //受理时间
    private String receiveTime ;
    //受理状态
    private int receiveStatus ;
    //指派车辆列表
    private List<EventInfoAssignCarBean> assignCarList ;

//    public void byMap( Map map ){
//
//        setAssignId( ( Long )map.getOrDefault( "assignId" , new Long( 0 ) ) ) ;
//        setHospName( ( String )map.get( "hospName" ) ) ;
//        setReceiveTime( ( String )map.get( "receiveTime" ) ) ;
//        setReceiveStatus( ( Integer ) map.getOrDefault( "receiveStatus" , new Integer( 0 ) ) ) ;
//
//    }

    public void setAssignCarListByMapList(List<Map> list ) {

        assignCarList = new ArrayList<>() ;
        if( list == null || list.size() <= 0 ){
            return ;
        }
        Iterator<Map> ite = list.iterator() ;
        while( ite.hasNext() ){
            EventInfoAssignCarBean bean = new EventInfoAssignCarBean() ;
//            bean.byMap( ite.next() ) ;
            BeanUtil.transMap2Bean( ite.next() , bean ) ;
            assignCarList.add( bean ) ;
        }

    }
}