package com.emgcy120.core.system.event.service.impl;

import com.emgcy120.core.system.event.entity.AssignCar120;
import com.emgcy120.core.system.event.mapper.AssignCar120Mapper;
import com.emgcy120.core.system.event.service.IAssignCar120Service;
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
 * @since 2017-12-04
 */
@Service
public class AssignCar120ServiceImpl extends ServiceImpl<AssignCar120Mapper, AssignCar120> implements IAssignCar120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(AssignCar120ServiceImpl.class);
	
	@Autowired
	private AssignCar120Mapper assignCar120Dao;
	
}
