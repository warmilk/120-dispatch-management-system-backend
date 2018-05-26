package com.emgcy120.core.system.call.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.system.call.entity.CallRecord120;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.emgcy120.core.system.call.web.dto.CallRecordBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;


/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
public interface CallRecord120Mapper extends BaseMapper<CallRecord120> {

    List<CallRecordBean> selectMulti( @Param("ew") EntityWrapper ew);

    List<CallRecordBean> selectMultiInPage(Page page , @Param("ew") EntityWrapper ew);

}