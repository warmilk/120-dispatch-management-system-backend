package com.emgcy120.core.system.sys.service.impl;

import com.emgcy120.core.common.base.BaseMsg;
import com.emgcy120.core.common.util.TokenGenerator;
import com.emgcy120.core.system.sys.entity.UserToken120;
import com.emgcy120.core.system.sys.mapper.UserToken120Mapper;
import com.emgcy120.core.system.sys.service.IUserToken120Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-15
 */
@Service
public class UserToken120ServiceImpl extends ServiceImpl<UserToken120Mapper, UserToken120> implements IUserToken120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(UserToken120ServiceImpl.class);
	
	@Autowired
	private UserToken120Mapper userTokenDao;

	//12小时后过期
	private final static int EXPIRE = 3600 * 12;

	@Override
	public String createToken(Long userId) {

		//生成一个token
		String token = TokenGenerator.generateValue();

		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		UserToken120 tokenEntity = userTokenDao.selectById(userId);
		if(tokenEntity == null){
			tokenEntity = new UserToken120();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			userTokenDao.insert(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			userTokenDao.updateById(tokenEntity);
		}

		return token ;

	}
}
