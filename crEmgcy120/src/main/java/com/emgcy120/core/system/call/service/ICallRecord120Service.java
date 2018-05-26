package com.emgcy120.core.system.call.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.system.call.entity.CallRecord120;
import com.baomidou.mybatisplus.service.IService;
import com.emgcy120.core.system.call.web.dto.CallRecordAddReqDto;
import com.emgcy120.core.system.call.web.dto.CallRecordBean;
import com.emgcy120.core.system.call.web.dto.CallRecordListAllReqDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
public interface ICallRecord120Service extends IService<CallRecord120> {

    Page<CallRecordBean> listAll(CallRecordListAllReqDto req );

//    Page<CallRecordBean> page(int page, int pageSize);

    /**
     * 获取今日通话记录列表（只显示当前登录用户的）
     * @return
     */
    List<CallRecordBean> today();

//    Page<CallRecordBean> listAll(int page, int pageSize);

//    List<CallRecordBean> page( EntityWrapper ew, int offset,int pageSize);

    void add(CallRecordAddReqDto req);
}
