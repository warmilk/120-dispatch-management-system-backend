package com.emgcy120.core.system.org.web;


import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.base.BaseListDataDto;
import com.emgcy120.core.system.org.service.IOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-28
 */
@Api( value = "医院／单位／科室" )
@Controller
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private IOrgService orgService ;

    /**
     * 获取医院列表
     * @return
     */
    @ApiOperation( value = "获取医院列表" , notes = "获取医院列表" )
    @GetMapping( "/hospList" )
    @ResponseBody
    public ReturnMap hospList(){

        return orgService.hospList() ;

    }

}
