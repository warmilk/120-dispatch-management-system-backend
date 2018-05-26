package com.emgcy120.core.system.call.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.system.call.entity.BlackList120;
import com.baomidou.mybatisplus.service.IService;
import com.emgcy120.core.system.call.web.dto.BlackListAddReqDto;
import com.emgcy120.core.system.call.web.dto.BlackListBean;
import com.emgcy120.core.system.call.web.dto.BlackListListReqDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
public interface IBlackList120Service extends IService<BlackList120> {

    Page<BlackListBean> list(BlackListListReqDto req);

    void add(BlackListAddReqDto req);

    void addList(List<BlackListAddReqDto> reqDtos);
}
