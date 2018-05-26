package com.emgcy120.core.system.call.web;

import com.emgcy120.core.system.base.BaseResDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.emgcy120.core.system.call.service.IPhone120Service;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.emgcy120.core.system.base.BasePageResDto;
import com.emgcy120.core.system.call.entity.Phone120;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.emgcy120.core.common.annotation.RepeatUrlData;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
//@Controller
//@RequestMapping("/call/phone120")
public class Phone120Controller {

	private static final Logger logger = LoggerFactory.getLogger(Phone120Controller.class);
	
	@Autowired
	private IPhone120Service phone120Service;
	
//	@RequiresPermissions(请填入权限编码)
	@ApiOperation(value = "获取列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "page", value = "页码", dataType = "Integer"),
			@ApiImplicitParam(name = "limit", value = "页数量", dataType = "Integer") })
	@GetMapping("/list")
	@ResponseBody
	public BasePageResDto<Phone120> list(@RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int limit, Phone120 entity) {
		Page<Phone120> currentPage = new Page<Phone120>();
		currentPage.setCurrent(page);
		currentPage.setSize(limit);
		Wrapper<Phone120> wrapper = new EntityWrapper<Phone120>();
	    wrapper.orderBy("id", false);
	    Page<Phone120> selectPage = phone120Service.selectPage(currentPage, wrapper);
		return new BasePageResDto<Phone120>(selectPage.getRecords(), selectPage.getTotal());
	}
	
//	@RequiresPermissions(请填入权限编码)
	@ApiOperation(value = "根据id获取信息")
	@GetMapping("/getInfo")
	@ResponseBody
	public Phone120 getInfo(@RequestParam @ApiParam(name = "id", value = "id", required = true) long id) {
		return phone120Service.selectById(id);
	}
	
//	@RequiresPermissions(请填入权限编码)
	@ApiOperation(value = "根据id删除信息")
	@GetMapping("/del")
	@ResponseBody
	public BaseResDto del(@RequestParam @ApiParam(name = "id", value = "id", required = true) long id) {
		phone120Service.deleteById(id) ;
        return BaseResDto.getSuccess() ;
	}
	
//	@RequiresPermissions(请填入权限编码)
	@PostMapping("/saveOrEdit")
	@RepeatUrlData
	@ApiOperation(value = "新增或修改信息")
	@ResponseBody
	public BaseResDto saveOrEdit(Phone120 entity) {
		phone120Service.insertOrUpdate(entity) ;
        return BaseResDto.getSuccess() ;
	}
	
}
