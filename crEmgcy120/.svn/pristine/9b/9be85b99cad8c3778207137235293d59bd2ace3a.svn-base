package com.emgcy120.core.common.exception;

import com.emgcy120.core.common.enm.ErrorCode;

/**
 * Created by weijieliao on 2017/11/16.
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -8174190030634004388L;

    private int errorCode ;
    private String errorMsg ;

    public CustomException( ErrorCode errorCode ){
        this.errorCode = errorCode.getCode() ;
        this.errorMsg = errorCode.getDescription() ;
    }

    public CustomException( int errorCode , String errorMsg ){

        this.errorCode = errorCode ;
        this.errorMsg = errorMsg ;

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
