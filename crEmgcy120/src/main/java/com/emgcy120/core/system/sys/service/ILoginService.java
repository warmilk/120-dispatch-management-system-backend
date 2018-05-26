package com.emgcy120.core.system.sys.service;

import com.emgcy120.core.system.sys.web.dto.LoginReqDto;

/**
 * Created by weijieliao on 2017/11/22.
 */
public interface ILoginService {

    String login(LoginReqDto req);

}
