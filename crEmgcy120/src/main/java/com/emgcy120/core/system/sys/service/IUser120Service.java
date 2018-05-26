package com.emgcy120.core.system.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.sys.entity.User120;
import com.baomidou.mybatisplus.service.IService;
import com.emgcy120.core.system.sys.web.dto.UserAddReqDto;
import com.emgcy120.core.system.sys.web.dto.UserChangePwdReqDto;
import com.emgcy120.core.system.sys.web.dto.UserListReqDto;
import com.emgcy120.core.system.sys.web.dto.UserUpdateReqDto;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-15
 */
public interface IUser120Service extends IService<User120> {

    Page list(UserListReqDto req);

    void changeStatus(long id, int status);

    void add(UserAddReqDto req);

    void updateInfo(UserUpdateReqDto req);

    void delete(long id);

    void changePwd(UserChangePwdReqDto req);

    ReturnMap info(Long id);

    Set<String> getRoles(Long userId);
}
