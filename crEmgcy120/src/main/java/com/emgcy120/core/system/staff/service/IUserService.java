package com.emgcy120.core.system.staff.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.system.staff.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.emgcy120.core.system.staff.web.dto.StaffListReqDto;

import java.util.Map;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-06
 */
public interface IUserService extends IService<User> {

    Page list(StaffListReqDto req) ;

    Map info(long id);
}
