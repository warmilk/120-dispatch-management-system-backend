package com.emgcy120.core.common.exception;

import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.base.BaseResDto;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author chenshuzhuo
 * @since 2017-10-25
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 拦截自定义的错误
	 * @param e
	 * @return
	 */
	@ExceptionHandler( value=CustomException.class )
	@ResponseBody
	public ReturnMap onCustomException(CustomException e ){

		return ReturnMap.error( e.getErrorCode() , e.getErrorMsg() ) ;

	}

	/**
	 * 拦截参数校验时报的错
	 * @param e
	 * @return
	 */
	@ExceptionHandler( value= { BindException.class , MethodArgumentNotValidException.class } )
	@ResponseBody
	public ReturnMap onBindException( Exception e ){

		String error = "" ;
		if( e instanceof BindException ){
			error = ( ( BindException )e ).getAllErrors().get( 0 ).getDefaultMessage() ;
		}
		else if( e instanceof MethodArgumentNotValidException ){
			error = ( ( MethodArgumentNotValidException )e ).getBindingResult().getAllErrors()
					.get( 0 ).getDefaultMessage() ;
		}

		return ReturnMap.error( ErrorCode.REQUEST_PARAM_ERROR.getCode() ,
				ErrorCode.REQUEST_PARAM_ERROR.getDescription()+error ) ;

	}

	/**
	 * 拦截其他报错
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ReturnMap defaultErrorHandler( Exception e) throws Exception {

		e.printStackTrace() ;

		return ReturnMap.error( ErrorCode.SERVER_ERROR ) ;

	}
	
}
