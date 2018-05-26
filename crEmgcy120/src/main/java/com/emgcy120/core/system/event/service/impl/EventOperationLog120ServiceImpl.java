package com.emgcy120.core.system.event.service.impl;

import com.emgcy120.core.system.event.entity.EventOperationLog120;
import com.emgcy120.core.system.event.mapper.EventOperationLog120Mapper;
import com.emgcy120.core.system.event.service.IEventOperationLog120Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-05
 */
@Service
public class EventOperationLog120ServiceImpl extends ServiceImpl<EventOperationLog120Mapper, EventOperationLog120> implements IEventOperationLog120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(EventOperationLog120ServiceImpl.class);
	
	@Autowired
	private EventOperationLog120Mapper eventOperationLog120Dao;
	
}
