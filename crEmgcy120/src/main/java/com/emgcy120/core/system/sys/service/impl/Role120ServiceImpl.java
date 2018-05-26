package com.emgcy120.core.system.sys.service.impl;

import com.emgcy120.core.system.sys.entity.Role120;
import com.emgcy120.core.system.sys.mapper.Role120Mapper;
import com.emgcy120.core.system.sys.service.IRole120Service;
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
 * @since 2017-11-15
 */
@Service
public class Role120ServiceImpl extends ServiceImpl<Role120Mapper, Role120> implements IRole120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Role120ServiceImpl.class);
	
	@Autowired
	private Role120Mapper role120Dao;
	
}
