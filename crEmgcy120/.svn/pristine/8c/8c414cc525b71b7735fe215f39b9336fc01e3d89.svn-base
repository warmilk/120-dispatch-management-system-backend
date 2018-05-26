package com.emgcy120.core.common.shiro;

import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.system.base.BaseResDto;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * @author bgy
 * @date 2017-11-14
 * 
 */
public class ShiroOAuthFilter extends AuthenticatingFilter {
	
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token
        String token = getRequestToken((HttpServletRequest) request);

        if(StringUtils.isBlank(token)){
            return null;
        }

        return new ShiroOAuthToken(token);
    }
    
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }
    
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    	
        //获取请求token，如果token不存在，直接返回401
        String token = getRequestToken((HttpServletRequest) request);
        if(StringUtils.isBlank(token)){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setContentType("application/json;charset=utf-8");
            String json = new Gson().toJson(BaseResDto.getError( ErrorCode.USER_ACCESS_TOKEN_ERROR_NOTEXISTS ));
            httpResponse.getWriter().print(json);

            return false;
        }

        return executeLogin(request, response);
    }
    
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        e.printStackTrace() ;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        String json = "" ;
//        try {
//            //处理登录失败的异常
//            Throwable throwable = e.getCause() == null ? e : e.getCause();
//            String json = new Gson().toJson( BaseResDto.getError( ErrorCode.USER_ACCESS_TOKEN_ERROR_EXCEPTION.getCode() ,
//                    ErrorCode.USER_ACCESS_TOKEN_ERROR_EXCEPTION.getDescription()+throwable.getMessage() ) );
//            httpResponse.getWriter().print(json);
//        } catch (IOException e1) {
//        	e1.printStackTrace();
//        }
        if( e instanceof ShiroCustomException ){
            json = new Gson().toJson( BaseResDto.getError( ( ( ShiroCustomException )e ).getErrorCode()
                    , ( ( ShiroCustomException )e ).getErrorMsg() ) ) ;
        }
        else{
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            json = new Gson().toJson( BaseResDto.getError( ErrorCode.USER_ACCESS_TOKEN_ERROR_EXCEPTION.getCode() ,
                    ErrorCode.USER_ACCESS_TOKEN_ERROR_EXCEPTION.getDescription()+throwable.getMessage() ) );
        }
        try {
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {
        	e1.printStackTrace();
        }

        return false;
    }
	
    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpRequest){
        //从header中获取token
        String token = httpRequest.getHeader("token");

        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = httpRequest.getParameter("token");
        }

        return token;
    }
	

}
