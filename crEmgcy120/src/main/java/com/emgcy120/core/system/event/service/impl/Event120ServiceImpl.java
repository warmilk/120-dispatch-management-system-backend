package com.emgcy120.core.system.event.service.impl;

import com.emgcy120.core.system.event.entity.Event120;
import com.emgcy120.core.system.event.mapper.Event120Mapper;
import com.emgcy120.core.system.event.service.IEvent120Service;
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
 * @since 2017-11-16
 */
@Service
public class Event120ServiceImpl extends ServiceImpl<Event120Mapper, Event120> implements IEvent120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Event120ServiceImpl.class);
	
	@Autowired
	private Event120Mapper event120Dao;
	
}
