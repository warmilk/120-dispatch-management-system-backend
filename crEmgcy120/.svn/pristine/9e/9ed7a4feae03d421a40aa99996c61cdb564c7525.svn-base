package com.emgcy120.core.system.event.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.system.event.entity.Event120;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.emgcy120.core.system.event.web.dto.EventListItemBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-16
 */
public interface Event120Mapper extends BaseMapper<Event120> {

    int countMulti(@Param( "ew") EntityWrapper ew);

    List<EventListItemBean> selectMultiInPage(Page<EventListItemBean> selectPage, @Param( "ew") EntityWrapper ew);

    Map baseInfo(long eventId);

    /**
     * 普通事件统计
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String,Object>> commonEventCount(
            @Param( "startTime" )String startTime , @Param( "endTime" )String endTime ) ;

    /**
     * 事故类型统计
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String,Object>> accidentTypeProportionCount(
            @Param( "startTime" )String startTime , @Param( "endTime" )String endTime ) ;

}