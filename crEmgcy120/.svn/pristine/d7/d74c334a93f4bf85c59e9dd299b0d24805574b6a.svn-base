package com.emgcy120.core.common.shiro;

import com.emgcy120.core.common.enm.ErrorCode;
import org.apache.shiro.authc.AuthenticationException;

/**
 * 
 * @author chenshuzhuo
 * @since 2017-10-25
 */
public class ShiroCustomException extends AuthenticationException{

    private static final long serialVersionUID = -7062314498052602011L;

    private int errorCode ;
    private String errorMsg ;

    public ShiroCustomException(int errorCode , String errorMsg ) {

        super();
        this.errorCode = errorCode ;
        this.errorMsg = errorMsg ;

    }

    public ShiroCustomException( ErrorCode error ) {

        super();
        this.errorCode = error.getCode() ;
        this.errorMsg = error.getDescription() ;

    }

    public ShiroCustomException() {
        super();
    }

    public ShiroCustomException(String message) {
        super(message);
    }

 
    public ShiroCustomException(Throwable cause) {
        super(cause);
    }

    public ShiroCustomException(String message, Throwable cause) {
        super(message, cause);
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
