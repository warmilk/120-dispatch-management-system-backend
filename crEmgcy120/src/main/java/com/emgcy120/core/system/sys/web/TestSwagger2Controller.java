package com.emgcy120.core.system.sys.web;

import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.sys.web.dto.TestSwagger2TestReqDto;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by weijieliao on 2018/1/16.
 */
@Api( value = "testSwagger2" )
@Controller
@RequestMapping( "/testSwagger2" )
public class TestSwagger2Controller {

    @ApiOperation( value = "测试swagger2" , notes = "测试swagger2" )
    @PostMapping( "/test" )
    @ResponseBody
    public ReturnMap test(@RequestBody @Valid TestSwagger2TestReqDto req ){

        return ReturnMap.ok()
                .put( "result01" , req.getParam01() )
                .put( "result02" , req.getParam02() )
                ;

    }

}
