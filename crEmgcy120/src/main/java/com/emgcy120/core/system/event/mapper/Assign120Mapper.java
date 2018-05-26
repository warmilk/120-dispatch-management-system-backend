package com.emgcy120.core.system.event.mapper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emgcy120.core.system.event.entity.Assign120;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.emgcy120.core.system.event.web.dto.EventListAssignBean;
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
public interface Assign120Mapper extends BaseMapper<Assign120> {

    List<EventListAssignBean> selectEventListAssignBeanList(
            @Param( "ew" ) EntityWrapper<EventListAssignBean> ew ) ;

    List<Map> eventInfoAssignList(long eventId);

    /**
     * 平均处置时长
     * @param ew
     * @return
     */
    int avgTime(@Param( "ew" ) EntityWrapper ew );

    /**
     * 有派单的事件数量
     * @param startTime
     * @param endTime
     * @return
     */
//    int assignCount( @Param( "startTime" )String startTime , @Param( "endTime" )String endTime ) ;

    /**
     * 有效派车的事件数量
     * @param startTime
     * @param endTime
     * @return
     */
    int assignCarCount(@Param( "startTime" )String startTime , @Param( "endTime" )String endTime ) ;

    /**
     * 现场处置的事件数量
     * @param startTime
     * @param endTime
     * @return
     */
    int assignFinishCount( @Param( "startTime" )String startTime , @Param( "endTime" )String endTime ) ;

    /**
     * 响应时间统计（按日）
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String,Object>> responseTimeCountDays(
            @Param( "startTime" )String startTime , @Param( "endTime" )String endTime ) ;

    /**
     * 响应时间统计（按周）
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String,Object>> responseTimeCountWeeks(
            @Param( "startTime" )String startTime , @Param( "endTime" )String endTime );

    /**
     * 响应时间统计（按月）
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String,Object>> responseTimeCountMonths(
            @Param( "startTime" )String startTime , @Param( "endTime" )String endTime );

}