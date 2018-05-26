package com.emgcy120.core.system.monitor.web;

import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.monitor.service.IMonitorService;
import com.emgcy120.core.system.monitor.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by weijieliao on 2018/1/3.
 */
@Controller
@RequestMapping( "/monitor" )
public class MonitorCongroller {

    @Autowired
    IMonitorService monitorService ;

    /**
     * 急救数据统计
     * @param req
     * @return
     */
    @PostMapping( "/emgcyCount" )
    @ResponseBody
    public ReturnMap emgcyCount(@Valid MonitorEmgcyCountReqDto req ){

        return monitorService.emgcyCount( req ) ;

    }

    /**
     * 普通事件统计
     * @param req
     * @return
     */
    @PostMapping( "/commonEventCount" )
    @ResponseBody
    public ReturnMap commonEventCount( @Valid MonitorCommonEventCountReqDto req ){

        return monitorService.commonEventCount( req ) ;

    }

    /**
     * 普通事件派单统计
     * @param req
     * @return
     */
    @PostMapping( "/commonEventAssignCount" )
    @ResponseBody
    public ReturnMap commonEventAssignCount( @Valid MonitorCommonEventAssignCountReqDto req ){

        return monitorService.commonEventAssignCount( req ) ;

    }

    /**
     * 事故类型比例统计
     * @param req
     * @return
     */
    @PostMapping( "/accidentTypeProportionCount" )
    @ResponseBody
    public ReturnMap accidentTypeProportionCount( @Valid MonitorAccidentTypeProportionCountReqDto req ){

        return monitorService.accidentTypeProportionCount( req ) ;

    }

    /**
     * 响应时间统计
     * @param req
     * @return
     */
    @PostMapping( "/responseTimeCount" )
    @ResponseBody
    public ReturnMap responseTimeCount( @Valid MonitorResponseTimeCountReqDto req ){

        return monitorService.responseTimeCount( req ) ;

    }

}
