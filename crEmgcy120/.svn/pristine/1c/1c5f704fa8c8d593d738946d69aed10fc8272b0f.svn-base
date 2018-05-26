package com.emgcy120.core.system.staff.web;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.staff.service.IUserService;
import com.emgcy120.core.system.staff.web.dto.StaffListReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by weijieliao on 2017/12/6.
 */
@Controller
@RequestMapping( "/staff" )
public class StaffController {

    @Autowired
    IUserService userService ;

    /**
     * 获取人员列表
     * @param req
     * @return
     */
    @PostMapping( "/list" )
    @ResponseBody
    public ReturnMap list(StaffListReqDto req ){

        return ReturnMap.ok().put(Constant.KEY_LIST , userService.list( req ) ) ;

    }

    /**
     * 获取人员详情
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping( "/info/{id}" )
    @ResponseBody
    public ReturnMap info(@PathVariable( "id" )long id) throws Exception {

        return ReturnMap.okAndFill( userService.info( id ) ) ;

    }

}
