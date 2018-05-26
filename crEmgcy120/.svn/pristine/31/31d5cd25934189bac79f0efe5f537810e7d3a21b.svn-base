package com.emgcy120.core.system.call.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.system.call.entity.BlackList120;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.emgcy120.core.system.call.web.dto.BlackListBean;
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
public interface BlackList120Mapper extends BaseMapper<BlackList120> {


    int countMulti(@Param( "ew" ) EntityWrapper ew);

    List<BlackListBean> selectMultiInPage(Page<BlackListBean> selectPage, @Param( "ew" ) EntityWrapper ew);
}