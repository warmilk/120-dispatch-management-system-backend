package com.emgcy120.core.system.sys.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.sys.service.IPwdApply120Service;
import com.emgcy120.core.system.sys.web.dto.PwdApplyApplyReqDto;
import com.emgcy120.core.system.sys.web.dto.PwdApplyListReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-15
 */
@Api( value = "pwdApply" )
@Controller
@RequestMapping("/pwdApply")
public class PwdApplyController {

    @Autowired
    IPwdApply120Service pwdApply120Service ;

    /**
     * 获取重置密码申请列表
     * @param req
     * @return
     */
    @ApiOperation( value = "获取重置密码申请列表" , notes = "获取重置密码申请列表" )
    @PostMapping( "/list" )
    @ResponseBody
    public ReturnMap list(@ModelAttribute PwdApplyListReqDto req ){

        Page page = pwdApply120Service.list( req ) ;

        return ReturnMap.ok()
                .put( Constant.KEY_PAGE_INDEX , req.getPageIndex() )
                .put( Constant.KEY_PAGE_SIZE , req.getPageSize() )
                .put( Constant.KEY_TOTAL_SIZE , page.getTotal() )
                .put( Constant.KEY_LIST , page.getRecords() )
                ;

    }

    /**
     * 获取重置密码申请详情
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation( value = "获取重置密码申请详情" , notes = "获取重置密码申请详情" )
    @GetMapping( "/info/{id}" )
    @ResponseBody
    public ReturnMap info(@PathVariable( "id" ) long id ) throws Exception {

        return ReturnMap.okAndFill( pwdApply120Service.info( id ) ) ;

    }

    /**
     * 恢复初始密码
     * @param id
     * @return
     */
    @ApiOperation( value = "恢复初始密码" , notes = "恢复初始密码" )
    @GetMapping( "/recoverPwd/{id}" )
    @ResponseBody
    public ReturnMap recoverPwd(@PathVariable( "id" ) long id ){

        pwdApply120Service.recoverPwd( id ) ;

        return ReturnMap.ok() ;

    }

    /**
     * 忽略重置密码申请
     * @param id
     * @return
     */
    @ApiOperation( value = "忽略重置密码申请" , notes = "忽略重置密码申请" )
    @GetMapping( "/ignore/{id}" )
    @ResponseBody
    public ReturnMap ignore( @PathVariable( "id" )long id ){

        pwdApply120Service.ignore( id ) ;

        return ReturnMap.ok() ;

    }

    /**
     * 申请重置密码
     * @param req
     * @return
     */
    @ApiOperation( value = "申请重置密码" , notes = "申请重置密码" )
    @PostMapping( "/apply" )
    @ResponseBody
    public ReturnMap apply( PwdApplyApplyReqDto req ){

        pwdApply120Service.apply( req ) ;

        return ReturnMap.ok() ;

    }
	
}
