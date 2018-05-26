package com.emgcy120.core.system.sys.mapper;

import com.emgcy120.core.system.sys.entity.User120;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;


/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-15
 */
public interface User120Mapper extends BaseMapper<User120> {

    List<String> getRoles(Long userId);

}