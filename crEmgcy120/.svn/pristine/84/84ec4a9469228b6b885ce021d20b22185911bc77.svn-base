package com.emgcy120.core.system.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emgcy120.core.system.sys.entity.DictItem;
import com.emgcy120.core.system.sys.mapper.DictItemMapper;
import com.emgcy120.core.system.sys.service.IDictItemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 字典明细表 服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-05
 */
@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements IDictItemService {
	
	private static final Logger logger = LoggerFactory.getLogger(DictItemServiceImpl.class);
	
	@Autowired
	private DictItemMapper dictItemDao;

	@Override
	public List<Map<String, Object>> regionList() {

		return dictItemDao.list( "region" ) ;

	}

}
