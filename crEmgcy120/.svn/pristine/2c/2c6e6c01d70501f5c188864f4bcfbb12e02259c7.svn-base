package com.emgcy120.core.system.sys.web;

import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.sys.service.IUser120Service;
import com.emgcy120.core.system.sys.web.dto.UserAddReqDto;
import com.emgcy120.core.system.sys.web.dto.UserChangePwdReqDto;
import com.emgcy120.core.system.sys.web.dto.UserListReqDto;
import com.emgcy120.core.system.sys.web.dto.UserUpdateReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by weijieliao on 2017/12/12.
 */
@Api( value = "user" )
@Controller
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    IUser120Service user120Service ;

    /**
     * 获取用户列表
     * @param req
     * @return
     */
    @ApiOperation( value = "获取用户列表" , notes = "获取用户列表" )
    @PostMapping( "/list" )
    @ResponseBody
    public ReturnMap list(@ModelAttribute UserListReqDto req ){

        return ReturnMap.ok().put( Constant.KEY_LIST , user120Service.list( req ) ) ;

    }

    /**
     * 获取用户详情
     * @param id
     * @return
     */
    @ApiOperation( value = "获取用户详情" , notes = "获取用户详情" )
    @GetMapping( "/info/{id}" )
    @ResponseBody
    public ReturnMap info( @PathVariable( "id" ) Long id ){

        return user120Service.info( id ) ;

    }

    /**
     * 改变用户账户状态
     * @param id
     * @param status
     * @return
     */
    @ApiOperation( value = "改变用户账户状态" , notes = "改变用户账户状态" )
    @GetMapping( "/status/{id}/{status}" )
    @ResponseBody
    public ReturnMap status(@PathVariable( "id" ) @ApiParam( value = "用户id" ) long id ,
                            @PathVariable( "status" ) @ApiParam( value = "状态" ) int status ){

        user120Service.changeStatus( id , status ) ;

        return ReturnMap.ok() ;

    }

    /**
     * 新增用户
     * @param req
     * @return
     */
    @ApiOperation( value = "新增用户" , notes = "新增用户" )
    @PostMapping( "/add" )
    @ResponseBody
    public ReturnMap add( @Valid @ModelAttribute UserAddReqDto req ){

        user120Service.add( req ) ;

        return ReturnMap.ok() ;

    }

    /**
     *  更新用户信息
     * @param req
     * @return
     */
    @ApiOperation( value = "更新用户信息" , notes = "更新用户信息" )
    @PostMapping( "/updateInfo" )
    @ResponseBody
    public ReturnMap updateInfo( @Valid @ModelAttribute UserUpdateReqDto req ){

        user120Service.updateInfo( req ) ;

        return ReturnMap.ok() ;

    }

    /**
     * 修改密码
     * @param req
     * @return
     */
    @ApiOperation( value = "修改密码" , notes = "修改密码" )
    @PostMapping( "/changePwd" )
    @ResponseBody
    public ReturnMap changePwd( @Valid @ModelAttribute UserChangePwdReqDto req ){

        user120Service.changePwd( req ) ;

        return ReturnMap.ok() ;

    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @ApiOperation( value = "删除用户信息" , notes = "删除用户信息" )
    @GetMapping( "/delete/{id}" )
    @ResponseBody
    public ReturnMap delete( @PathVariable( "id" )long id ){

        user120Service.delete( id ) ;

        return ReturnMap.ok() ;

    }

}
