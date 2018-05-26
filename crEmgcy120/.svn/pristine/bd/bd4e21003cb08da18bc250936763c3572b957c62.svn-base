package com.emgcy120.core.system.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.common.util.TokenGenerator;
import com.emgcy120.core.system.sys.entity.User120;
import com.emgcy120.core.system.sys.service.ILoginService;
import com.emgcy120.core.system.sys.service.IUser120Service;
import com.emgcy120.core.system.sys.service.IUserToken120Service;
import com.emgcy120.core.system.sys.web.dto.LoginReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weijieliao on 2017/11/22.
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private IUser120Service userService ;
    @Autowired
    private IUserToken120Service userTokenService ;

    @Override
    public String login(LoginReqDto req) {

        String username = req.getUsername();
        String password = req.getPassword();

        EntityWrapper<User120> userWrapper = new EntityWrapper<>();
        userWrapper.eq( "email" , username ) ;
        List<User120> userList = userService.selectList(userWrapper) ;

        if(userList==null||userList.size()==0){
            throw new CustomException( ErrorCode.PASSWORD_ERROR ) ;
        }
        else if(userList.size()>1){
            throw new CustomException( ErrorCode.ACCOUNT_MULTI_USER_ERROR ) ;
        }
        else {
            User120 user = userList.get(0);
            if (user.getStatus() == 0) {
                throw new CustomException(ErrorCode.ACCOUNT_NEVER_ACTIVATE);
            }
            if (user.getStatus() == -1) {
                throw new CustomException(ErrorCode.ACCOUNT_IS_DISABLE);
            }
            if (!user.getPassword().equals(TokenGenerator.entryptPassword(password, user.getSalt()))) {
                throw new CustomException(ErrorCode.PASSWORD_ERROR);
            }

            //设置用户session
            ShiroUserUtil.setUserToSession( user ) ;

            return userTokenService.createToken(user.getId());
        }

    }

}
