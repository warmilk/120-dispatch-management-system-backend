package com.emgcy120.core.system.call.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.system.call.entity.Contact120;
import com.emgcy120.core.system.call.entity.Phone120;
import com.emgcy120.core.system.call.mapper.Contact120Mapper;
import com.emgcy120.core.system.call.mapper.Phone120Mapper;
import com.emgcy120.core.system.call.service.IContact120Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emgcy120.core.system.call.web.dto.ContactAddReqDto;
import com.emgcy120.core.system.call.web.dto.ContactBean;
import com.emgcy120.core.system.call.web.dto.ContactUpdateReqDto;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
@Service
public class Contact120ServiceImpl extends ServiceImpl<Contact120Mapper, Contact120> implements IContact120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Contact120ServiceImpl.class);
	
	@Autowired
	private Contact120Mapper contactDao ;
	@Autowired
	private Phone120Mapper phoneDao ;

	/**
	 * 获取联系人列表
	 * @return
	 */
	@Override
	public List<ContactBean> list() {

		EntityWrapper ew = new EntityWrapper() ;
		ew.where( "1=1" ) ;
		ew.orderBy( "createTime" , false ) ;

		return contactDao.selectMulti( ew ) ;

	}

	@Override
	@Transactional
	public void add(ContactAddReqDto req) {

		String phoneNumber = req.getPhoneNumber() ;

		Phone120 phone = new Phone120() ;
		phone.setNumber( phoneNumber ) ;
		phone = phoneDao.selectOne( phone ) ;
		if( phone == null ){
			phone = new Phone120() ;
//			phone.setPhoneType( req.getPhoneType() ) ;
			phone.setNumber( phoneNumber ) ;
			phoneDao.insert( phone ) ;
		}

		//查询联系人是否已经存在
		Contact120 contact = new Contact120() ;
		contact.setPhoneId( phone.getId() ) ;
		contact = contactDao.selectOne( contact ) ;
		if( contact != null ){
			//联系人已经存在
			throw new CustomException( ErrorCode.CONTACTS_EXISTED ) ;
		}

		contact = new Contact120() ;
		contact.setPhoneId( phone.getId() ) ;
		contact.setOrgName( req.getOrgName() ) ;
		contact.setRemarkName( req.getRemarkName() ) ;
		contact.setCreateTime( new Date() ) ;
		contactDao.insert( contact ) ;

	}

	@Override
	public void delete(long id) {

		Contact120 contact = contactDao.selectById( id ) ;
		if( contact == null ){
			//用户不存在
			throw new CustomException(ErrorCode.CONTACTS_NOT_EXISTED ) ;
		}
		//直接删除
		contactDao.deleteById( id ) ;

	}

	@Override
	@Transactional
	public void update(ContactUpdateReqDto req) {

		Phone120 phone = new Phone120() ;
		phone.setNumber( req.getPhoneNumber() ) ;
		phone = phoneDao.selectOne( phone ) ;
		if( phone == null ){
			phone = new Phone120() ;
//			phone.setPhoneType( req.getPhoneType() ) ;
			phone.setNumber( req.getPhoneNumber() ) ;
			phoneDao.insert( phone ) ;
		}

		//查询联系人是否存在
		Contact120 contact = contactDao.selectById( req.getId() ) ;
		if( contact == null ){
			//联系人不存在
			throw new CustomException( ErrorCode.CONTACTS_NOT_EXISTED ) ;
		}

		contact.setOrgName( req.getOrgName() ) ;
		contact.setRemarkName( req.getRemarkName() ) ;
		contact.setPhoneId( phone.getId() ) ;
		contact.setCreateTime( new Date() ) ;

		contactDao.updateById( contact ) ;

	}

	@Override
	public Map info(long id) {

		Contact120 contact = contactDao.selectById( id ) ;
		if( contact == null ){
			throw new CustomException( ErrorCode.CONTACTS_NOT_EXISTED ) ;
		}

		Map<String,Object> returnMap = new HashMap() ;
		returnMap.put( "id" , contact.getId() ) ;
		returnMap.put( "phoneNumber" , phoneDao.selectById( contact.getPhoneId() ).getNumber() ) ;
		returnMap.put( "orgName" , contact.getOrgName() ) ;
		returnMap.put( "remarkName" , contact.getRemarkName() ) ;

		return returnMap ;

	}

}
