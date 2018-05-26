package com.emgcy120.core.system.monitor.service;

import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.monitor.web.dto.*;

/**
 * Created by weijieliao on 2018/1/3.
 */
public interface IMonitorService {

    /**
     * 急救数据统计
     * @param req
     * @return
     */
    ReturnMap emgcyCount(MonitorEmgcyCountReqDto req);

    /**
     * 普通事件统计
     * @param req
     * @return
     */
    ReturnMap commonEventCount(MonitorCommonEventCountReqDto req);

    /**
     * 普通事件派单统计
     * @param req
     * @return
     */
    ReturnMap commonEventAssignCount(MonitorCommonEventAssignCountReqDto req);

    /**
     * 事故类型比例统计
     * @param req
     * @return
     */
    ReturnMap accidentTypeProportionCount(MonitorAccidentTypeProportionCountReqDto req);

    /**
     * 响应时间统计
     * @param req
     * @return
     */
    ReturnMap responseTimeCount(MonitorResponseTimeCountReqDto req);
}
