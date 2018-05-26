package com.emgcy120.core.system.call.web;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.call.web.dto.CallRecordAddReqDto;
import com.emgcy120.core.system.call.web.dto.CallRecordListAllReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import com.emgcy120.core.system.call.service.ICallRecord120Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.plugins.Page;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
@Api( value = "通话记录" )
@Controller
@RequestMapping( "/callRecord" )
public class CallRecord120Controller {

	private static final Logger logger = LoggerFactory.getLogger(CallRecord120Controller.class);
	
	@Autowired
	private ICallRecord120Service callRecordService;

	/**
	 * 获取全部通话记录
	 * @param req
	 * @return
	 */
	@ApiOperation( value = "获取全部通话记录" , notes = "获取全部通话记录" )
	@PostMapping( "/listAll" )
	@ResponseBody
	public ReturnMap listAll(@ModelAttribute CallRecordListAllReqDto req ){

		Page page = callRecordService.listAll( req ) ;

		return ReturnMap.ok()
				.put( Constant.KEY_PAGE_INDEX , req.getPageIndex() )
				.put( Constant.KEY_PAGE_SIZE , req.getPageSize() )
				.put( Constant.KEY_TOTAL_SIZE , page.getTotal() )
				.put( Constant.KEY_LIST , page.getRecords() )
				;

	}

	/**
	 * 获取今日通话记录列表（只显示当前登录用户的）
	 * @return
	 */
	@ApiOperation( value = "获取今日通话记录列表（只显示当前登录用户的）" , notes = "获取今日通话记录列表（只显示当前登录用户的）" )
	@GetMapping( "/today" )
	@ResponseBody
	public ReturnMap today(){

		return ReturnMap.ok().put( Constant.KEY_LIST , callRecordService.today() ) ;

	}

	/**
	 * 新增通话记录
	 * @return
	 */
	@ApiOperation( value = "新增通话记录" , notes = "新增通话记录" )
	@PostMapping( "/add" )
	@ResponseBody
	public ReturnMap add( @Valid @ModelAttribute CallRecordAddReqDto req ){

		callRecordService.add( req ) ;

		return ReturnMap.ok() ;

	}
	
}
