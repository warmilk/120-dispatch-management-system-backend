package com.emgcy120.core.system.call.web;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.call.web.dto.ContactAddReqDto;
import com.emgcy120.core.system.call.web.dto.ContactUpdateReqDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.emgcy120.core.system.call.service.IContact120Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
@Controller
@RequestMapping("/contact")
public class Contact120Controller {

	private static final Logger logger = LoggerFactory.getLogger(Contact120Controller.class);
	
	@Autowired
	private IContact120Service contactService;

	/**
	 * 获取联系人信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping( "/info/{id}" )
	@ResponseBody
	public ReturnMap info(@PathVariable( "id" )long id ){

		return ReturnMap.okAndFill( contactService.info( id ) ) ;

	}

	/**
	 * 获取联系人列表
	 * @return
	 */
	@GetMapping( "/list" )
	@ResponseBody
	public ReturnMap list(){

		return ReturnMap.ok().put(Constant.KEY_LIST , contactService.list() ) ;

	}

	/**
	 *  新增联系人
	 * @return
	 */
	@PostMapping( "/add" )
	@ResponseBody
	public ReturnMap add(@Valid ContactAddReqDto req ){

		contactService.add( req ) ;

		return ReturnMap.ok() ;

	}

	/**
	 * 删除联系人
	 * @param id
	 * @return
	 */
	@GetMapping( "/delete/{id}" )
	@ResponseBody
	public ReturnMap delete( @PathVariable( "id" )long id ){

		contactService.delete( id ) ;

		return ReturnMap.ok() ;

	}

	/**
	 * 更新联系人
	 * @param req
	 * @return
	 */
	@PostMapping( "/update" )
	@ResponseBody
	public ReturnMap update( @Valid ContactUpdateReqDto req ){

		contactService.update( req ) ;

		return ReturnMap.ok() ;

	}

}
