package com.emgcy120.core.system.call.web;


import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.base.BasePageResDto;
import com.emgcy120.core.system.base.BaseResDto;
import com.emgcy120.core.system.call.web.dto.BlackListAddReqDto;
import com.emgcy120.core.system.call.web.dto.BlackListAddReqDtoModel;
import com.emgcy120.core.system.call.web.dto.BlackListListReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.emgcy120.core.system.call.service.IBlackList120Service;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.emgcy120.core.system.call.entity.BlackList120;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
@Api( value = "blackList" )
@Controller
@RequestMapping("/blackList")
public class BlackList120Controller {

	private static final Logger logger = LoggerFactory.getLogger(BlackList120Controller.class);
	
	@Autowired
	private IBlackList120Service blackListService;

	/**
	 * 获取黑名单列表
	 * @param req
	 * @return
	 */
	@ApiOperation( value = "获取黑名单列表" , notes = "获取黑名单列表" )
	@PostMapping( "/list" )
	@ResponseBody
	public ReturnMap list(@ModelAttribute BlackListListReqDto req ){

		Page page = blackListService.list( req ) ;

		return ReturnMap.ok()
				.put( Constant.KEY_PAGE_INDEX , req.getPageIndex() )
				.put( Constant.KEY_PAGE_SIZE , req.getPageSize() )
				.put( Constant.KEY_TOTAL_SIZE , page.getTotal() )
				.put( Constant.KEY_LIST , page.getRecords() )
				;

	}

	/**
	 * 新增黑名单
	 * @return
	 */
	@ApiOperation( value = "新增黑名单" , notes = "新增黑名单" )
	@PostMapping( "/add" )
	@ResponseBody
	public ReturnMap add(@Valid @ModelAttribute BlackListAddReqDto req ){

		blackListService.add( req ) ;

		return ReturnMap.ok() ;

	}

    /**
     * 批量新增黑名单
     * @return
     */
    @ApiOperation( value = "批量新增黑名单" , notes = "批量新增黑名单" )
    @PostMapping( "/addList" )
    @ResponseBody
	public ReturnMap add(@Valid @RequestBody BlackListAddReqDtoModel model) {

        blackListService.addList(model.getList());

        return ReturnMap.ok();

    }
	
}
