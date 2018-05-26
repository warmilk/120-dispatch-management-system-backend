package com.emgcy120.core.system.staff.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.system.staff.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.emgcy120.core.system.staff.web.dto.StaffListItemBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
  * 系统用户表 Mapper 接口
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-06
 */
public interface UserMapper extends BaseMapper<User> {


    int countMulti(@Param( "ew" ) EntityWrapper ew);

    List<StaffListItemBean> selectMultiInPage(Page<StaffListItemBean> selectPage, @Param( "ew" )EntityWrapper ew);
}