package com.emgcy120.core.system.sys.web;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.sys.service.IDictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by weijieliao on 2018/1/3.
 */
@Api( value = "系统" )
@Controller
@RequestMapping( "/sys" )
public class SystemController {

    @Autowired
    IDictItemService dictItemService ;

    /**
     * 获取乡镇列表
     * @return
     */
    @ApiOperation( value = "获取乡镇列表" , notes = "获取乡镇列表" )
    @GetMapping( "/regionList" )
    @ResponseBody
    public ReturnMap regionList(){

        return ReturnMap.ok().put(Constant.KEY_REGION_LIST , dictItemService.regionList() ) ;

    }

}
