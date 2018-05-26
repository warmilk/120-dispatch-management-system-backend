package com.emgcy120.core.system.base;

import com.emgcy120.core.common.constants.ReturnCode;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.util.BeanUtil;
import io.swagger.annotations.ApiModelProperty;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by weijieliao on 2017/11/16.
 */
public class BaseResDto {

    @ApiModelProperty(value="返回码")
    private int returnCode ;
    @ApiModelProperty(value="错误码")
    private int errorCode ;
    @ApiModelProperty(value="错误信息")
    private String errorMsg ;

    public static <T extends BaseResDto> T fromMap( Map map , Class<T> clazz )
            throws IllegalAccessException, InstantiationException {

        T t = clazz.newInstance() ;
        t.success() ;
        BeanUtil.transMap2Bean( map , t ) ;

        return t ;

    }

    public static BaseResDto getSuccess(){

        BaseResDto res = new BaseResDto() ;
        res.returnCode = ReturnCode.RETURN_CODE_SUCCESS ;

        return res ;

    }

    public static BaseResDto getError(ErrorCode errorCode ){

        BaseResDto res = new BaseResDto() ;
        res.returnCode = ReturnCode.RETURN_CODE_FAIL ;
        res.errorCode = errorCode.getCode() ;
        res.errorMsg = errorCode.getDescription() ;

        return res ;

    }

    public static BaseResDto getError(int errorCode , String errorMsg ){

        BaseResDto res = new BaseResDto() ;
        res.returnCode = ReturnCode.RETURN_CODE_FAIL ;
        res.errorCode = errorCode ;
        res.errorMsg = errorMsg ;

        return res ;

    }

    public void success(){

        this.returnCode = ReturnCode.RETURN_CODE_SUCCESS ;

    }

    public void error(ErrorCode errorCode ){

        this.returnCode = ReturnCode.RETURN_CODE_FAIL ;
        this.errorCode = errorCode.getCode() ;
        this.errorMsg = errorCode.getDescription() ;

    }

    public void error(int errorCode , String errorMsg ){

        this.returnCode = ReturnCode.RETURN_CODE_FAIL ;
        this.errorCode = errorCode ;
        this.errorMsg = errorMsg ;

    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
