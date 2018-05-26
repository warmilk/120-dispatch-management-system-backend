package com.emgcy120.core.system.event.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.event.web.dto.*;

/**
 * Created by weijieliao on 2017/11/16.
 */
public interface IEventService {

    /**
     * 受理普通急救
     * @param req
     */
    void receiveCommon(EventReceiveCommonReqDto req);

    /**
     * 受理群体事件
     * @param req
     */
    void receiveGroup(EventReceiveGroupReqDto req);

    /**
     * 获取事件列表
     * @param req
     * @return
     */
    Page<EventListItemBean> list(EventListReqDto req);

    /**
     * 获取事件详情
     * @param eventId
     * @return
     */
    ReturnMap info(long eventId);
}
