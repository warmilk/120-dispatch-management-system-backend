package com.emgcy120.core.system.event.service.impl;

import com.emgcy120.core.system.event.entity.Receive120;
import com.emgcy120.core.system.event.mapper.Receive120Mapper;
import com.emgcy120.core.system.event.service.IReceive120Service;
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
public class Receive120ServiceImpl extends ServiceImpl<Receive120Mapper, Receive120> implements IReceive120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Receive120ServiceImpl.class);
	
	@Autowired
	private Receive120Mapper receive120Dao;
	
}
