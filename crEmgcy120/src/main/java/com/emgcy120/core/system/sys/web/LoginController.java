package com.emgcy120.core.system.sys.web;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.sys.service.ILoginService;
import com.emgcy120.core.system.sys.web.dto.LoginReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @date 2017-10-23
 */
@Api( value = "login" )
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	ILoginService loginService ;

	/**
	 * 登入
	 * @param req
	 * @return
	 */
	@ApiOperation( value = "登入" , notes = "登入" )
	@PostMapping( "/login" )
	@ResponseBody
	public ReturnMap login(@Valid @ModelAttribute LoginReqDto req ) {

		return ReturnMap.ok().put(Constant.KEY_TOKEN , loginService.login( req ) ) ;

	}

	/**
	 * 登出
	 * @return
	 */
    @ApiOperation( value = "登出" , notes = "登出" )
	@GetMapping( "/logout" )
	@ResponseBody
	public ReturnMap logout(){

		SecurityUtils.getSubject().logout() ;

		return ReturnMap.ok() ;

	}

}
