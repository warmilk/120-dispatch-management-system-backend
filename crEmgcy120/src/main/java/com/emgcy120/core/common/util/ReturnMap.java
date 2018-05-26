package com.emgcy120.core.common.util;

import com.emgcy120.core.common.constants.ReturnCode;
import com.emgcy120.core.common.enm.ErrorCode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 返回数据使用map
 *
 * Created by weijieliao on 2017/12/12.
 */
public class ReturnMap extends HashMap<String,Object> {

    private static final long serialVersionUID = 7112701833586532147L;

    private static final String KEY_RETURN_CODE = "returnCode" ;
    private static final String KEY_ERROR_CODE = "errorCode" ;
    private static final String KEY_ERROR_MSG = "errorMsg" ;

    public ReturnMap(){

        //默认成功
        put(KEY_RETURN_CODE, ReturnCode.RETURN_CODE_SUCCESS ) ;

    }

    /**
     * 成功
     * @return
     */
    public static ReturnMap ok(){

        return new ReturnMap() ;

    }

    /**
     * 成功并填充数据
     * @param map
     * @return
     */
    public static ReturnMap okAndFill( Map map ){

        ReturnMap rm = ok() ;
        rm.putAll( map ) ;

        return rm ;

    }

    /**
     * 失败
     * @return
     */
    public static ReturnMap error(){

        return error( ErrorCode.UNKNOWN ) ;

    }

    /**
     * 失败
     * @param errorCode
     * @return
     */
    public static ReturnMap error( ErrorCode errorCode ){

        ReturnMap rm = new ReturnMap() ;
        rm.put(KEY_RETURN_CODE, ReturnCode.RETURN_CODE_FAIL ) ;
        rm.put(KEY_ERROR_CODE, errorCode.getCode() ) ;
        rm.put(KEY_ERROR_MSG, errorCode.getDescription() ) ;

        return rm ;

    }

    public static ReturnMap error( int errorCode , String errorMsg ){

        ReturnMap rm = new ReturnMap() ;
        rm.put(KEY_RETURN_CODE, ReturnCode.RETURN_CODE_FAIL ) ;
        rm.put(KEY_ERROR_CODE, errorCode ) ;
        rm.put(KEY_ERROR_MSG, errorMsg ) ;

        return rm ;

    }

    /**
     * 使得可以链式调用
     * @param key
     * @param value
     * @return
     */
    public ReturnMap put( String key , Object value ){

        super.put( key , value ) ;
        return this ;

    }

}
