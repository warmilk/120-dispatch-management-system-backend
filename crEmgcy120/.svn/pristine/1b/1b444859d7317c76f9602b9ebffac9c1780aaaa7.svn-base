package com.emgcy120.core.system.call.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emgcy120.core.system.call.entity.Contact120;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.emgcy120.core.system.call.web.dto.ContactBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
public interface Contact120Mapper extends BaseMapper<Contact120> {


    List<ContactBean> selectMulti(@Param( "ew" ) EntityWrapper ew);
}