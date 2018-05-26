package com.emgcy120.core.system.base;

import lombok.Data;

import java.util.List;

/**
 * Created by weijieliao on 2017/11/23.
 */
@Data
public class BaseListDataDto<T> extends BaseResDto{

    private List<T> list ;

    public static BaseListDataDto getSuccess( List list ){

        BaseListDataDto dto = new BaseListDataDto() ;
        dto.success() ;
        dto.setList( list ) ;
        return dto ;

    }

}
