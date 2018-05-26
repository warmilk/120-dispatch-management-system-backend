package com.emgcy120.core.system.org.service.impl;

import com.emgcy120.core.common.config.AppConfig;
import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.constants.ReturnCode;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.inHosp.InHospUtil;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.org.entity.Org;
import com.emgcy120.core.system.org.mapper.OrgMapper;
import com.emgcy120.core.system.org.service.IOrgService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emgcy120.core.system.org.web.dto.BaseHospBean;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 机构表 服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-28
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrgServiceImpl.class);

	@Autowired
	InHospUtil inHospUtil ;

	/**
	 * 获取医院列表
	 * @return
	 */
	@Override
	public ReturnMap hospList() {

		return ReturnMap.ok().put( Constant.KEY_DATA , inHospUtil.hospList() ) ;

	}
}
