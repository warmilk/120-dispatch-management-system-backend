package com.emgcy120.core.system.inHosp.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by weijieliao on 2018/1/10.
 */
@Data
public class InHospReceiveResponseReqDto {

    //受理结果：1、接受，2、拒绝
    @NotNull( message = "受理结果不能为空" )
    private Integer result ;
    //事件id
    @NotBlank( message = "事件id不能为空" )
    private String eventId ;
    //医院uuid
    @NotNull( message = "医院uuid不能为空" )
    private Long hospUuid ;
    //受理人id
    @NotBlank( message = "受理人id不能为空" )
    private Long receiverId ;

}
