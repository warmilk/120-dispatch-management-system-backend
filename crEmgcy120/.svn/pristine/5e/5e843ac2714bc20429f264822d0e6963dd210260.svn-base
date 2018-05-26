package com.emgcy120.core.system.inHosp.service.impl;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.system.event.entity.Assign120;
import com.emgcy120.core.system.event.entity.Receive120;
import com.emgcy120.core.system.event.mapper.Assign120Mapper;
import com.emgcy120.core.system.event.mapper.Receive120Mapper;
import com.emgcy120.core.system.inHosp.dto.InHospReceiveResponseReqDto;
import com.emgcy120.core.system.inHosp.service.IInHospService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by weijieliao on 2018/1/10.
 */
@Service
public class InHospServiceImpl implements IInHospService {

    @Autowired
    Assign120Mapper assign120Mapper ;
    @Autowired
    Receive120Mapper receive120Mapper ;

    /**
     * 受理响应
     * @param req
     */
    @Override
    @Transactional
    public void receiveResponse(InHospReceiveResponseReqDto req) {

        Date now = new Date() ;

        //更改指派表
        Assign120 selectAssign = new Assign120() ;
        selectAssign.setEventId( req.getEventId() ) ;
        selectAssign.setHospId( req.getHospUuid() ) ;
        //必须是待受理状态
        selectAssign.setReceiveStatus(Constant.RECEIVE_STATUS_WAIT_FOR ) ;
        selectAssign = assign120Mapper.selectOne( selectAssign ) ;
        if( selectAssign == null ){
            throw new CustomException( ErrorCode.REQUEST_RESOURCE_NOT_EXIST ) ;
        }
        int receiveStatus ;
        if( req.getResult() == 1 ){
            //接受
            receiveStatus = Constant.RECEIVE_STATUS_ACCEPT ;
        }
        else{
            //拒绝
            receiveStatus = Constant.RECEIVE_STATUS_REFUSE ;
        }
        //修改状态
        selectAssign.setReceiveStatus( receiveStatus ) ;
        //受理人
        selectAssign.setReceiverId( req.getReceiverId() ) ;
        //响应时间
        selectAssign.setAssignResTime( now ) ;
        //更新
        assign120Mapper.updateById( selectAssign ) ;

        if( req.getResult() == 1 ){
            //接受则更改受理表
            Receive120 receive = receive120Mapper.selectById( req.getEventId() ) ;
            if( receive.getStartTime() == null ){
                //开始受理时间为空，说明此次受理的单位是该事件第一家受理的单位，记录开始时间
                receive.setStartTime( now ) ;
                receive120Mapper.updateById( receive ) ;
            }
        }

        //TODO 通知前端

    }

}
