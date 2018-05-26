package com.emgcy120.core.system.monitor.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by weijieliao on 2018/1/3.
 */
@Data
public class MonitorCommonEventCountReqDto {

    //开始时间
    @NotBlank( message = "开始时间不能为空" )
    private String startTime ;
    //结束时间
    @NotBlank( message = "结束时间不能为空" )
    private String endTime ;

}
