package com.emgcy120.core.system.sys.web.dto;

import com.emgcy120.core.system.base.BasePageReqDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by weijieliao on 2017/12/12.
 */
@ApiModel
@Data
public class UserListReqDto extends BasePageReqDto{

    //用户名
    @ApiModelProperty( value = "用户名" )
    private String name ;

}
