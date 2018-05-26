package com.emgcy120.core.system.event.web;


import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.base.BasePageResDto;
import com.emgcy120.core.system.base.BaseResDto;
import com.emgcy120.core.system.event.service.IEventService;
import com.emgcy120.core.system.event.web.dto.*;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-16
 */
@Api( value = "事件" )
@Controller
@RequestMapping("/event")
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private IEventService eventService ;

	/**
	 * 受理普通急救
	 * @param req
	 * @return
	 */
	@ApiOperation( value = "受理普通急救" , notes = "受理普通急救" )
	@RequestMapping( value="/receiveCommon" , method= RequestMethod.POST )
	@ResponseBody
	public ReturnMap receiveCommon(@ModelAttribute @Valid EventReceiveCommonReqDto req ){

		eventService.receiveCommon( req ) ;

		return ReturnMap.ok() ;

	}

	/**
	 * 受理群体事件
	 * @param req
	 * @return
	 */
	@ApiOperation( value = "受理群体事件" , notes = "受理群体事件" )
	@RequestMapping( value="/receiveGroup" , method= RequestMethod.POST )
	@ResponseBody
	public ReturnMap receiveGroup(@Valid @ModelAttribute EventReceiveGroupReqDto req ){

		eventService.receiveGroup( req ) ;

		return ReturnMap.ok() ;

	}

	/**
	 * 获取事件列表
	 * @param req
	 * @return
	 */
	@ApiOperation( value = "获取事件列表" , notes = "获取事件列表" )
	@PostMapping( "/list" )
	@ResponseBody
	public ReturnMap list(@Valid @ModelAttribute EventListReqDto req ){

		return ReturnMap.ok().put(Constant.KEY_LIST , eventService.list( req ) ) ;

	}

	/**
	 * 获取事件详情
	 * @param eventId
	 * @return
	 */
	@ApiOperation( value = "获取事件详情" , notes = "获取事件详情" )
	@GetMapping( "/info/{eventId}" )
	@ResponseBody
	public ReturnMap info(@PathVariable( "eventId" ) long eventId ){

		return eventService.info( eventId ) ;

	}

}
