package com.emgcy120.core.system.monitor.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.call.mapper.CallRecord120Mapper;
import com.emgcy120.core.system.event.mapper.Assign120Mapper;
import com.emgcy120.core.system.event.mapper.Event120Mapper;
import com.emgcy120.core.system.event.mapper.Receive120Mapper;
import com.emgcy120.core.system.monitor.service.IMonitorService;
import com.emgcy120.core.system.monitor.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by weijieliao on 2018/1/3.
 */
@Service
public class MonitorServiceImpl implements IMonitorService {

    @Autowired
    Event120Mapper event120Mapper ;
    @Autowired
    Assign120Mapper assign120Mapper ;
    @Autowired
    CallRecord120Mapper callRecord120Mapper ;
    @Autowired
    Receive120Mapper receive120Mapper ;

    /**
     * 急救数据统计
     * @param req
     * @return
     */
    @Override
    public ReturnMap emgcyCount(MonitorEmgcyCountReqDto req) {

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ) ;
        Date startDate ;
        Date endDate ;
        try {
            startDate = sdf.parse( req.getStartTime() ) ;
            endDate = sdf.parse( req.getEndTime() ) ;
        } catch (ParseException e) {
            e.printStackTrace();
            //日期格式错误
            throw new CustomException( ErrorCode.DATA_FORMAT_ERROR ) ;
        }
        Date preStartDate = new Date( startDate.getTime()-( endDate.getTime()+1000*60*60*24-startDate.getTime() ) ) ;
        Date preEndDate = new Date( startDate.getTime()-1000*60*60*24 ) ;

        //TODO 报警数可能要根据打进电话次数来统计

        //总报警数
        EntityWrapper eventCountEw = new EntityWrapper() ;
        //呼入且有被接听的电话才算
        eventCountEw.eq( "call_type" , Constant.CALL_TYPE_IN ) ;
        eventCountEw.eq( "had_connected" , Constant.HAD_CONNECTED ) ;
        int eventCount = callRecord120Mapper.selectCount( eventCountEw ) ;

        //新增报警数
        EntityWrapper newEventCountEw = new EntityWrapper() ;
        newEventCountEw.eq( "call_type" , Constant.CALL_TYPE_IN ) ;
        newEventCountEw.eq( "had_connected" , Constant.HAD_CONNECTED ) ;
        newEventCountEw.between( "call_time" , req.getStartTime()+" 00:00:00" , req.getEndTime()+"23:59:59" ) ;
        int newEventCount = callRecord120Mapper.selectCount( newEventCountEw ) ;

        //报警数增长率
        //先获取同期报警数
        double eventGrowthRate ;
        EntityWrapper preEventCountEw = new EntityWrapper() ;
        preEventCountEw.eq( "call_type" , Constant.CALL_TYPE_IN ) ;
        preEventCountEw.eq( "had_connected" , Constant.HAD_CONNECTED ) ;
        preEventCountEw.between( "call_time" , sdf.format( preStartDate )+" 00:00:00" ,
                sdf.format( preEndDate )+"23:59:59" ) ;
        int preEventCount = callRecord120Mapper.selectCount( preEventCountEw ) ;
        if( preEventCount <= 0 ){
            //同期没有报警数，设置增长率为0
            eventGrowthRate = 0 ;
        }
        else{
            eventGrowthRate = ( newEventCount - preEventCount )*1.0 / preEventCount * 100 ;
        }

        //新增派单数，从指派表中统计
        EntityWrapper newAssignCountEw = new EntityWrapper() ;
        newAssignCountEw.between( "assign_start_time" , req.getStartTime()+" 00:00:00" ,
                req.getEndTime()+"23:59:59" ) ;
        int newAssignCount = assign120Mapper.selectCount( newAssignCountEw ) ;

        //派单数增长率
        //先获取同期派单数
        double assignGrowthRate ;
        EntityWrapper preAssignCountEw = new EntityWrapper() ;
        preAssignCountEw.between( "assign_start_time" , sdf.format( preStartDate )+" 00:00:00" ,
                sdf.format( preEndDate )+"23:59:59" ) ;
        int preAssignCount = assign120Mapper.selectCount( preAssignCountEw ) ;
        if( preAssignCount <= 0 ){
            //同期没有派单数，设置增长率为0
            assignGrowthRate = 0 ;
        }
        else{
            assignGrowthRate = ( newAssignCount - preAssignCount )*1.0 / preAssignCount * 100 ;
        }

        //回车数
        EntityWrapper newAssignCancelCountEw = new EntityWrapper() ;
        newAssignCancelCountEw.between( "assign_start_time" , req.getStartTime()+" 00:00:00" ,
                req.getEndTime()+"23:59:59" ).eq( "receiver_status" , Constant.RECEIVE_STATUS_REFUSE ) ;
        int newAssignCancelCount = assign120Mapper.selectCount( newAssignCancelCountEw ) ;

        //回车数增长率
        //先获取同期派单数
        double assignCancelGrowthRate ;
        EntityWrapper preAssignCancelCountEw = new EntityWrapper() ;
        preAssignCancelCountEw.between( "assign_start_time" , sdf.format( preStartDate )+" 00:00:00" ,
                sdf.format( preEndDate )+"23:59:59" ).eq( "receiver_status" , Constant.RECEIVE_STATUS_REFUSE ) ;
        int preAssignCancelCount = assign120Mapper.selectCount( preAssignCancelCountEw ) ;
        if( preAssignCancelCount <= 0 ){
            //同期没有回车数，设置增长率为0
            assignCancelGrowthRate = 0 ;
        }
        else{
            assignCancelGrowthRate = ( newAssignCancelCount - preAssignCancelCount )*1.0 / preAssignCancelCount * 100 ;
        }

        //随车入院数
        EntityWrapper newAssignFinishCountEw = new EntityWrapper() ;
        newAssignFinishCountEw.between( "assign_start_time" , req.getStartTime()+" 00:00:00" ,
                req.getEndTime()+"23:59:59" ).eq( "receiver_status" , Constant.RECEIVE_STATUS_ACCEPT )
                .eq( "execute_status" , Constant.EXECUTE_STATUS_FINISH ) ;
        int newAssignFinishCount = assign120Mapper.selectCount( newAssignFinishCountEw ) ;

        //随车入院数增长率
        //先获取同期随车入院数
        double assignFinishGrowthRate ;
        EntityWrapper preAssignFinishCountEw = new EntityWrapper() ;
        preAssignFinishCountEw.between( "assign_start_time" , sdf.format( preStartDate )+" 00:00:00" ,
                sdf.format( preEndDate )+"23:59:59" ).eq( "receiver_status" , Constant.RECEIVE_STATUS_ACCEPT )
                .eq( "execute_status" , Constant.EXECUTE_STATUS_FINISH ) ;
        int preAssignFinishCount = assign120Mapper.selectCount( preAssignFinishCountEw ) ;
        if( preAssignFinishCount <= 0 ){
            //同期没有随车入院数，设置增长率为0
            assignFinishGrowthRate = 0 ;
        }
        else{
            assignFinishGrowthRate = ( newAssignFinishCount - preAssignFinishCount )*1.0 / preAssignFinishCount * 100 ;
        }

        //平均处置时长，单位s
        EntityWrapper newAvgTimeEw = new EntityWrapper() ;
        newAvgTimeEw.between( "assign_start_time" , req.getStartTime()+" 00:00:00" ,
                req.getEndTime()+"23:59:59" ).eq( "receiver_status" , Constant.RECEIVE_STATUS_ACCEPT )
                .eq( "execute_status" , Constant.EXECUTE_STATUS_FINISH ) ;
        int newAvgTime = assign120Mapper.avgTime( newAvgTimeEw ) ;

        //平均处理时长增长率
        //先获取同期平均处理时长
        double avgTimeGrowthRate ;
        EntityWrapper preAvgTimeEw = new EntityWrapper() ;
        preAvgTimeEw.between( "assign_start_time" , sdf.format( preStartDate )+" 00:00:00" ,
                sdf.format( preEndDate )+"23:59:59" ).eq( "receiver_status" , Constant.RECEIVE_STATUS_ACCEPT )
                .eq( "execute_status" , Constant.EXECUTE_STATUS_FINISH ) ;
        int preAvgTime = assign120Mapper.avgTime( preAvgTimeEw ) ;
        if( preAvgTime <= 0 ){
            //同期没有平均处理时长，设置增长率为0
            avgTimeGrowthRate = 0 ;
        }
        else{
            avgTimeGrowthRate = ( newAvgTime - preAvgTime )*1.0 / preAvgTime * 100 ;
        }

        return ReturnMap.ok()
                .put( Constant.KEY_EVENT_COUNT , eventCount )
                .put( Constant.KEY_NEW_EVENT_COUNT , newEventCount )
                .put( Constant.KEY_EVENT_GROWTH_RATE , eventGrowthRate )
                .put( Constant.KEY_NEW_ASSIGN_COUNT , newAssignCount )
                .put( Constant.KEY_ASSIGN_GROWTH_RATE , assignGrowthRate )
                .put( Constant.KEY_NEW_ASSIGN_CANCEL_COUNT , newAssignCancelCount )
                .put( Constant.KEY_ASSIGN_CANCEL_GROWTH_RATE , assignCancelGrowthRate )
                .put( Constant.KEY_NEW_ASSIGN_FINISH_COUNT , newAssignFinishCount )
                .put( Constant.KEY_ASSIGN_FINISH_GROWTH_RATE , assignFinishGrowthRate )
                .put( Constant.KEY_NEW_AVG_TIME , newAvgTime )
                .put( Constant.KEY_AVG_TIME_GROWTH_RATE , avgTimeGrowthRate )
                ;

    }

    /**
     * 普通事件统计
     * @param req
     * @return
     */
    @Override
    public ReturnMap commonEventCount(MonitorCommonEventCountReqDto req) {

        return ReturnMap.ok().put( Constant.KEY_LIST ,
                event120Mapper.commonEventCount( req.getStartTime()+" 00:00:00" , req.getEndTime()+"23:59:59" ) ) ;

    }

    /**
     * 普通事件派单统计
     * @param req
     * @return
     */
    @Override
    public ReturnMap commonEventAssignCount(MonitorCommonEventAssignCountReqDto req) {

        //普通事件报警数
        int commonEventCount ;
        //派单率
        double receiveRate ;
        //有效派车率
        double assignCarRate ;
        //现场处置率
        double assignFinishRate ;

        //普通事件报警数，指明普通事件，就不能在通话记录表中查询了，需要在事件表中查询
        EntityWrapper commonEventCountEw = new EntityWrapper() ;
        commonEventCountEw.between( "create_time" , req.getStartTime()+" 00:00:00" , req.getEndTime()+"23:59:59" )
            .eq( "event_type" , Constant.EVENT_TYPE_COMMON ) ;
        commonEventCount = event120Mapper.selectCount( commonEventCountEw ) ;

        if( commonEventCount <= 0 ){
            receiveRate = 0 ;
            assignCarRate = 0 ;
            assignFinishRate = 0 ;
        }
        else{
            //派单率（受理率）可以在受理表中判断开始时间是否为空
            EntityWrapper receiveCountEw = new EntityWrapper() ;
            receiveCountEw.isNotNull( "start_time" ) ;
            int receiveCount = receive120Mapper.selectCount( receiveCountEw ) ;
            receiveRate = receiveCount*1.0/commonEventCount*100 ;

            //有效派车率
            int assignCarCount = assign120Mapper.assignCarCount( req.getStartTime()+" 00:00:00" ,
                    req.getEndTime()+"23:59:59" ) ;
            assignCarRate = assignCarCount*1.0/commonEventCount*100 ;

            //现场处置率
            int assignFinishCount = assign120Mapper.assignFinishCount( req.getStartTime()+" 00:00:00" ,
                    req.getEndTime()+"23:59:59" ) ;
            assignFinishRate = assignFinishCount*1.0/commonEventCount*100 ;
        }

        return ReturnMap.ok()
                .put( Constant.KEY_COMMON_EVENT_COUNT , commonEventCount )
                .put( Constant.KEY_RECEIVE_RATE, receiveRate )
                .put( Constant.KEY_ASSIGN_CAR_RATE, assignCarRate )
                .put( Constant.KEY_ASSIGN_FINISH_RATE , assignFinishRate )
                ;

    }

    /**
     * 事故类型比例统计
     * @param req
     * @return
     */
    @Override
    public ReturnMap accidentTypeProportionCount(MonitorAccidentTypeProportionCountReqDto req) {

        List<Map<String,Object>> list = event120Mapper.accidentTypeProportionCount( req.getStartTime()+" 00:00:00" ,
                req.getEndTime()+"23:59:59" ) ;
        //获取事件总数
        int eventAmount = 0 ;
        for( Map<String,Object> listItem : list ){
            eventAmount += ( Integer )listItem.getOrDefault( Constant.KEY_EVENT_COUNT , 0 ) ;
        }
        //计算各事故类型比例
        int size = list.size() ;
        double count = 0 ;
        for( int i = 0 ; i < size-1 ; i++ ){
            Map<String,Object> listItem = list.get( i ) ;
            double proportion = 0 ;
            if( eventAmount != 0 ){
                proportion = ( Double )listItem.getOrDefault( Constant.KEY_EVENT_COUNT , 0 )/eventAmount*100 ;
            }
            listItem.put( Constant.KEY_EVENT_PROPORTION , proportion ) ;
            count += proportion ;
        }
        //最后一项直接用100-前面累计的比例
        if( size >= 1 ){
            Map<String,Object> listItem = list.get( size-1 ) ;
            double proportion = 0 ;
            if( eventAmount != 0 ){
                proportion = 100-count ;
            }
            listItem.put( Constant.KEY_EVENT_PROPORTION , proportion ) ;
        }

        return ReturnMap.ok().put( Constant.KEY_LIST , list ) ;

    }

    /**
     * 响应时间统计
     * @param req
     * @return
     */
    @Override
    public ReturnMap responseTimeCount(MonitorResponseTimeCountReqDto req) {

        //根据时间跨度选择不同的时间分组单位：
        //1、小于1个月按日分组
        //2、大于1个月小于3个月按周分组
        //3、大于3个月按月分组

        //获取时间跨度天数
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ) ;
        Date startDate ;
        Date endDate ;
        try {
            startDate = sdf.parse( req.getStartTime() ) ;
            endDate = sdf.parse( req.getEndTime() ) ;
        } catch (ParseException e) {
            e.printStackTrace();
            //日期格式错误
            throw new CustomException( ErrorCode.DATA_FORMAT_ERROR ) ;
        }
        double days = ( endDate.getTime() - startDate.getTime() ) * 1.0 / 1000 / 60 / 60 / 24 ;

        List<Map<String,Object>> list ;

        if( days < 30 ){
            //小于1个月
            list = assign120Mapper.responseTimeCountDays( req.getStartTime()+" 00:00:00" ,
                    req.getEndTime()+"23:59:59" ) ;
        }
        else if( days >= 30 && days < 90 ){
            //大于1个月小于3个月
            list = assign120Mapper.responseTimeCountWeeks( req.getStartTime()+" 00:00:00" ,
                    req.getEndTime()+"23:59:59" ) ;
        }
        else{
            //大于3个月
            list = assign120Mapper.responseTimeCountMonths( req.getStartTime()+" 00:00:00" ,
                    req.getEndTime()+"23:59:59" ) ;
        }

        return ReturnMap.ok().put( Constant.KEY_LIST , list ) ;

    }

    public static void main( String[] args ) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ) ;
        Date date = sdf.parse( "2017-10-10" ) ;
        System.out.println( "date="+date.toString() ) ;

        Date startDate = sdf.parse( "2017-10-10" ) ;
        Date endDate = sdf.parse( "2017-10-20" ) ;
        Calendar startCalendar = Calendar.getInstance() ;
        startCalendar.setTime( startDate ) ;
        Calendar endCalendar = Calendar.getInstance() ;
        endCalendar.setTime( endDate ) ;
        System.out.println( startCalendar.compareTo( endCalendar ) ) ;

        Date preStartDate = new Date( startDate.getTime()-( endDate.getTime()+1000*60*60*24-startDate.getTime() ) ) ;
        Date preEndDate = new Date( startDate.getTime()-1000*60*60*24 ) ;
        System.out.println( sdf.format( preStartDate )+"<>"+sdf.format( preEndDate ) ) ;

    }

}
