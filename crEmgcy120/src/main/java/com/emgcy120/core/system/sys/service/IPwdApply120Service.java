package com.emgcy120.core.system.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.system.sys.entity.PwdApply120;
import com.baomidou.mybatisplus.service.IService;
import com.emgcy120.core.system.sys.web.dto.PwdApplyApplyReqDto;
import com.emgcy120.core.system.sys.web.dto.PwdApplyListReqDto;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-15
 */
public interface IPwdApply120Service extends IService<PwdApply120> {

    Page list(PwdApplyListReqDto req);

    Map info(long id);

    void recoverPwd(long id);

    /**
     * 忽略重置密码申请
     * @param id
     */
    void ignore(long id);

    void apply(PwdApplyApplyReqDto req);
}
