package com.emgcy120.core.system.event.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.config.AppConfig;
import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.inHosp.InHospUtil;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.common.util.BeanUtil;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.common.util.StringUtil;
import com.emgcy120.core.common.util.UUIDGenerator;
import com.emgcy120.core.system.event.entity.*;
import com.emgcy120.core.system.event.mapper.*;
import com.emgcy120.core.system.event.service.*;
import com.emgcy120.core.system.event.web.dto.*;
import com.emgcy120.core.system.sys.entity.User120;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by weijieliao on 2017/11/16.
 */
@Service
public class EventServiceImpl implements IEventService {

    @Autowired
    private AppConfig appConfig ;
    @Autowired
    RestTemplate restTemplate ;
    @Autowired
    InHospUtil inHospUtil ;

    @Autowired
    private Event120Mapper eventDao ;
    @Autowired
    private Receive120Mapper receiveDao;
//    @Autowired
//    private CommonEmgcy120Mapper commonEmgcyDao;
//    @Autowired
//    private GroupEmgcy120Mapper groupEmgcyDao;
    @Autowired
    private Assign120Mapper assignDao ;
    @Autowired
    private AssignCar120Mapper assignCarDao ;
    @Autowired
    private EventOperationLog120Mapper eventOperationLogDao ;

    /**
     * 受理普通急救
     * @param req
     */
    @Transactional
    @Override
    public void receiveCommon(EventReceiveCommonReqDto req) {

        Date now = new Date() ;
        User120 user = ( User120 ) SecurityUtils.getSubject().getPrincipal() ;
        String eventId = UUIDGenerator.generate() ;

        //事件表
        Event120 event = new Event120() ;
        event.setId( eventId ) ;
		event.setReporter( req.getReporter() ) ;
		event.setPhone( req.getPhone() ) ;
		event.setEventType( Constant.EVENT_TYPE_COMMON ) ;
        event.setRegion( req.getRegion() ) ;
		event.setPlace( req.getPlace() ) ;
		event.setRescueType( req.getRescueType() ) ;
		event.setLevel( req.getLevel() ) ;
        event.setOperatorId( user.getId() ) ;
        event.setPatientName( req.getPatientName() ) ;
        event.setPatientSex( req.getPatientSex() ) ;
        event.setPatientAge( req.getPatientAge() ) ;
        event.setPatientIdentity( req.getPatientIdentity() ) ;
        event.setReporterDesc( req.getReporterDesc() ) ;
        event.setPatientDesc( req.getPatientDesc() ) ;
        event.setCreateTime( now ) ;
        eventDao.insert( event ) ;

        //受理表
        Receive120 receive = new Receive120() ;
        receive.setEventId( eventId ) ;
        //普通急救指派的医院固定为1个
        receive.setHospNum( 1 ) ;
        receiveDao.insert( receive ) ;

        //指派表
        Assign120 assign = new Assign120() ;
        assign.setId( UUIDGenerator.generate() ) ;
        assign.setEventId( event.getId() ) ;
        assign.setHospId( req.getHospId() ) ;
        assign.setCarNum( req.getCarNum() ) ;
        assign.setReceiveStatus( Constant.RECEIVE_STATUS_WAIT_FOR ) ;
        assign.setExecuteStatus( Constant.EXECUTE_STATUS_NONE ) ;
        assign.setAssignStartTime( now ) ;
        assignDao.insert( assign ) ;

        //TODO 发送受理请求至院内工作站
//        HttpHeaders headers = new HttpHeaders() ;
//        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8") ;
//        headers.setContentType(type) ;
//        headers.add("Accept", MediaType.APPLICATION_JSON.toString()) ;
//        JSONObject jsonObj = new JSONObject() ;
//        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
//        restTemplate.postForObject( appConfig.getCrEmgcyBaseUrl() )

        inHospUtil.receiveCommon( req ) ;

    }

    @Transactional
    @Override
    public void receiveGroup(EventReceiveGroupReqDto req) {

        Date now = new Date() ;
        User120 user = ( User120 ) SecurityUtils.getSubject().getPrincipal() ;
        String eventId = UUIDGenerator.generate() ;

        //事件表
        Event120 event = new Event120() ;
        event.setId( eventId ) ;
        event.setReporter( req.getReporter() ) ;
        event.setPhone( req.getPhone() ) ;
        event.setEventType( Constant.EVENT_TYPE_GROUP ) ;
        event.setRegion( req.getRegion() ) ;
        event.setPlace( req.getPlace() ) ;
        event.setRescueType( req.getRescueType() ) ;
        event.setLevel( req.getLevel() ) ;
        event.setOperatorId( user.getId() ) ;
        event.setAccidentLevel( req.getAccidentLevel() ) ;
        event.setAccidentType( req.getAccidentType() ) ;
        event.setReporterDesc( req.getReporterDesc() ) ;
        event.setCreateTime( now ) ;
        eventDao.insert( event ) ;

        //受理表
        Receive120 receive = new Receive120() ;
        receive.setEventId( eventId ) ;
        receive.setHospNum( req.getHospNum() ) ;
        receiveDao.insert( receive ) ;

        //指派表
        Iterator<AssignBean> assignBeanIte = req.getAssignList().iterator() ;
        AssignBean assignBean ;
        Assign120 assign ;
        while( assignBeanIte.hasNext() ){
            assignBean = assignBeanIte.next() ;
            assign = new Assign120() ;
            assign.setId( UUIDGenerator.generate() ) ;
            assign.setEventId( event.getId() ) ;
            assign.setHospId( assignBean.getHospId() ) ;
            assign.setCarNum( assignBean.getCarNum() ) ;
            assign.setReceiveStatus( Constant.RECEIVE_STATUS_WAIT_FOR ) ;
            assign.setExecuteStatus( Constant.EXECUTE_STATUS_NONE ) ;
            assign.setAssignStartTime( now ) ;
            assignDao.insert( assign ) ;
        }

        //TODO 发送受理请求至院内工作站

    }

    /**
     * 获取事件列表
     * @param req
     * @return
     */
    @Override
    public Page<EventListItemBean> list(EventListReqDto req) {

        Page<EventListItemBean> returnPage = new Page() ;
        Page<EventListItemBean> selectPage = new Page() ;

        selectPage.setCurrent( req.getPageIndex() ) ;
        selectPage.setSize( req.getPageSize() ) ;

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ) ;

        EntityWrapper ew = new EntityWrapper() ;
        ew.where( "1=1" ) ;
        if( !StringUtil.isEmpty( req.getOperator() ) ){
            ew.eq( "u120.name" , req.getOperator() ) ;
        }
        if( req.getStartTime() != null && req.getStartTime() > 0 ){
            Date startDate = new Date() ;
            startDate.setTime( req.getStartTime() ) ;
            String likeStartTime = sdf.format( startDate )+"%" ;
            ew.like( "r.start_time" , likeStartTime ) ;
        }
        if( req.getEndTime() != null && req.getEndTime() > 0 ){
            Date endDate = new Date() ;
            endDate.setTime( req.getEndTime() ) ;
            String likeEndTime = sdf.format( endDate )+"%" ;
            ew.like( "r.end_time" , likeEndTime ) ;
        }
        if( req.getReceiveStatus() != null ){
            ew.eq( "a.receive_status" , req.getReceiveStatus() ) ;
        }
        if( !StringUtil.isEmpty( req.getHospital() ) ){
            ew.eq( "o.name" , req.getHospital() ) ;
        }
        if( req.getEventType() != null ){
            ew.eq( "e.event_type" , req.getEventType() ) ;
        }
        if( req.getPatientIdentity() != null ){
            ew.eq( "e.patient_identity" , req.getPatientIdentity() ) ;
        }
        if( !StringUtil.isEmpty( req.getReportPhone() ) ){
            ew.eq( "e.phone" , req.getReportPhone() ) ;
        }
        ew.groupBy( "e.id" ) ;
        //查询全部记录数
        returnPage.setTotal( eventDao.countMulti( ew ) ) ;
        //查询结果集
        ew.orderBy( "e.create_time" , false ) ;
        List<EventListItemBean> eventList = eventDao.selectMultiInPage( selectPage , ew ) ;

        //对每个事件记录填充指派单位列表
        Iterator<EventListItemBean> eventIte = eventList.iterator() ;
        EventListItemBean eventListItem ;
        while( eventIte.hasNext() ){
            eventListItem = eventIte.next() ;
            EntityWrapper<EventListAssignBean> selectEventListAssignBeanListEw = new EntityWrapper<>() ;
            selectEventListAssignBeanListEw.eq( "a.event_id" , eventListItem.getEventId() ) ;
            eventListItem.setAssignList( assignDao.selectEventListAssignBeanList( selectEventListAssignBeanListEw ) ) ;
        }

        returnPage.setRecords( eventList ) ;

        return returnPage ;

    }

    /**
     * 获取事件详情
     * @param eventId
     * @return
     */
    @Override
    public ReturnMap info(long eventId) {

        ReturnMap res = ReturnMap.ok() ;
        int carNum = 0 ;

        Map resultMap = eventDao.baseInfo( eventId ) ;
        if( resultMap == null ){
            throw new CustomException( ErrorCode.EVENT_NOT_EXISTED ) ;
        }
        //基本信息
        res.putAll( resultMap ) ;
        //指派医院列表
        List<Map> assignList = assignDao.eventInfoAssignList( eventId ) ;
        res.put( Constant.KEY_ASSIGN_LIST , assignList ) ;
        //遍历每个医院查询指派车辆
        Iterator<Map> assignListIte = assignList.iterator() ;
        while( assignListIte.hasNext() ){

            Map<String,Object> assignNext = assignListIte.next() ;
            //指派车辆列表
            List<Map> assignCarList = assignCarDao.eventInfoAssignListCarList(
                    ( Long )assignNext.get( Constant.KEY_ASSIGN_ID ) ) ;
            assignNext.put( Constant.KEY_ASSIGN_CAR_LIST , assignCarList ) ;
            carNum += assignCarList.size() ;

        }
        //指派车辆总数
        res.put( Constant.KEY_CAR_NUM , carNum ) ;
        res.put( Constant.KEY_OPE_LOG_LIST , eventOperationLogDao.eventInfoOpeLogList( eventId ) ) ;

        return res ;

    }

}
