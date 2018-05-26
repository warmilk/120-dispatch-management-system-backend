package com.emgcy120.core.system.sys.web.dto;

import com.emgcy120.core.common.util.DateUtil;
import com.emgcy120.core.system.sys.entity.User120;
import lombok.Data;

import java.text.SimpleDateFormat;

/**
 * Created by weijieliao on 2017/12/12.
 */
@Data
public class UserListItemBean {

    //用户id
    private long id ;
    //姓名
    private String name ;
    //电子邮件
    private String email ;
    //工号
    private String employeeId ;
    //手机号码
    private String phone ;
    //用户状态
    private int status ;
    //创建时间
    private String createTime ;

    public static UserListItemBean fromUser120(User120 user) {

        UserListItemBean bean = new UserListItemBean() ;
        if( user != null ){
            bean.setId( user.getId() ) ;
            bean.setName( user.getName() ) ;
            bean.setEmail( user.getEmail() ) ;
            bean.setEmployeeId( user.getEmployeeId() ) ;
            bean.setPhone( user.getPhone() ) ;
            bean.setStatus( user.getStatus() ) ;
            bean.setCreateTime(DateUtil.date2Str( user.getCreateTime() , new SimpleDateFormat( "yyyy-MM-dd" ) ) ) ;
        }

        return bean ;

    }
}
