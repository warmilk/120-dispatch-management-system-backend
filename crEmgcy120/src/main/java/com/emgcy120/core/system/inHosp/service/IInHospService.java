package com.emgcy120.core.system.inHosp.service;

import com.emgcy120.core.system.inHosp.dto.InHospReceiveResponseReqDto;

/**
 * Created by weijieliao on 2018/1/10.
 */
public interface IInHospService {

    /**
     * 受理响应
     * @param req
     */
    void receiveResponse(InHospReceiveResponseReqDto req);

}
