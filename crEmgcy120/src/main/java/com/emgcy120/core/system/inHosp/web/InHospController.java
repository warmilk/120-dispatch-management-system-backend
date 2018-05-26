package com.emgcy120.core.system.inHosp.web;

import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.inHosp.dto.InHospReceiveResponseReqDto;
import com.emgcy120.core.system.inHosp.service.IInHospService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by weijieliao on 2018/1/10.
 */
@Controller
@RequestMapping( "/inHosp" )
public class InHospController {

    @Autowired
    IInHospService inHospService ;

    /**
     * 受理响应
     * @param req
     * @return
     */
    @PostMapping( "/receiveResponse" )
    @ResponseBody
    public ReturnMap receiveResponse(@Valid InHospReceiveResponseReqDto req ){

        inHospService.receiveResponse( req ) ;

        return ReturnMap.ok() ;

    }

}
