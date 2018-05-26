package com.emgcy120.core.system.sys.service;


import com.emgcy120.core.system.sys.entity.User120;
import com.emgcy120.core.system.sys.entity.UserToken120;

import java.util.Set;

/**
 * shiro相关接口
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-06 8:49
 */
public interface IShiroService {
    /**
     * 获取用户权限列表
     */
//    Set<String> getUserPermissions(long userId);

    UserToken120 queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    User120 queryUser(Long userId);
}
