package com.emgcy120.core.system.call.service;

import com.emgcy120.core.system.call.entity.Contact120;
import com.baomidou.mybatisplus.service.IService;
import com.emgcy120.core.system.call.web.dto.ContactAddReqDto;
import com.emgcy120.core.system.call.web.dto.ContactBean;
import com.emgcy120.core.system.call.web.dto.ContactUpdateReqDto;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
public interface IContact120Service extends IService<Contact120> {

    /**
     * 获取联系人列表
     * @return
     */
    List<ContactBean> list() ;

    void add(ContactAddReqDto req);

    void delete(long id);

    void update(ContactUpdateReqDto req);

    Map info(long id);
}
