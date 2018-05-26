package com.emgcy120.core.system.call.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.common.util.StringUtil;
import com.emgcy120.core.common.util.UUIDGenerator;
import com.emgcy120.core.system.call.entity.CallRecord120;
import com.emgcy120.core.system.call.entity.Phone120;
import com.emgcy120.core.system.call.mapper.CallRecord120Mapper;
import com.emgcy120.core.system.call.mapper.Phone120Mapper;
import com.emgcy120.core.system.call.service.ICallRecord120Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emgcy120.core.system.call.web.dto.CallRecordAddReqDto;
import com.emgcy120.core.system.call.web.dto.CallRecordBean;
import com.emgcy120.core.system.call.web.dto.CallRecordListAllReqDto;
import com.emgcy120.core.system.sys.entity.User120;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
@Service
public class CallRecord120ServiceImpl extends ServiceImpl<CallRecord120Mapper, CallRecord120> implements ICallRecord120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(CallRecord120ServiceImpl.class);
	
	@Autowired
	private CallRecord120Mapper callRecordDao ;
	@Autowired
	private Phone120Mapper phoneDao ;

//	@Override
//	public Page<CallRecordBean> page(int page, int pageSize) {
//
//		long userId = ShiroUserUtil.getCurrentUser().getId() ;
//		Page<CallRecordBean> returnPage = new Page() ;
//		Page<CallRecordBean> selectPage = new Page() ;
//
//		selectPage.setCurrent( page ) ;
//		selectPage.setSize( pageSize ) ;
//
//		EntityWrapper ew = new EntityWrapper() ;
//		ew.eq( "user_id" , userId ) ;
//		returnPage.setTotal( callRecordDao.selectCount( ew ) ) ;
//		EntityWrapper ew02 = new EntityWrapper() ;
//		ew02.eq( "cr.user_id" , userId ) ;
//		ew02.orderBy( "callTime" , false ) ;
////		SqlHelper.fillWrapper( selectPage , ew02 ) ;
//		returnPage.setRecords( callRecordDao.selectMultiInPage( selectPage , ew02 ) ) ;
//
//		return returnPage ;
//	}

	@Override
	public Page<CallRecordBean> listAll(CallRecordListAllReqDto req) {

		Page<CallRecordBean> returnPage = new Page() ;
		Page<CallRecordBean> selectPage = new Page() ;

		selectPage.setCurrent( req.getPageIndex() ) ;
		selectPage.setSize( req.getPageSize() ) ;

		//查询全部记录数
		EntityWrapper ew = new EntityWrapper() ;
		ew.where( "1=1" ) ;
		String phoneNumber = req.getPhoneNumber() ;
		if( !StringUtil.isEmpty( phoneNumber ) ){
			//查询出phone id
			Phone120 phone = new Phone120() ;
			phone.setNumber( phoneNumber ) ;
			phone = phoneDao.selectOne( phone ) ;
			if( phone == null ){
				phone = new Phone120() ;
				phone.setNumber( phoneNumber ) ;
				phoneDao.insert( phone ) ;
			}
			ew.eq( "phone_id" , phone.getId() ) ;
		}
		if( req.getConnectStartTime() > 0 && req.getConnectEndTime() > 0 ){
			ew.between( "connect_time" , req.getConnectStartTime() , req.getConnectEndTime() ) ;
		}
		returnPage.setTotal( callRecordDao.selectCount( ew ) ) ;
		//查询结果集
		EntityWrapper ew02 = new EntityWrapper() ;
		ew02.where( "1" , 1 ) ;
		if( !StringUtil.isEmpty( phoneNumber ) ){
			ew02.eq( "p.number" , phoneNumber ) ;
		}
		if( req.getConnectStartTime() > 0 && req.getConnectEndTime() > 0 ){
			ew02.between( "cr.connect_time" , req.getConnectStartTime() , req.getConnectEndTime() ) ;
		}
		ew02.orderBy( "callTime" , false ) ;
		returnPage.setRecords( callRecordDao.selectMultiInPage( selectPage , ew02 ) ) ;

		return returnPage ;

	}

//	@Override
//	public Page<CallRecordBean> listAll(int page, int pageSize) {
//
//		Page<CallRecordBean> returnPage = new Page() ;
//		Page<CallRecordBean> selectPage = new Page() ;
//
//		selectPage.setCurrent( page ) ;
//		selectPage.setSize( pageSize ) ;
//
////		EntityWrapper ew = new EntityWrapper() ;
////		ew.eq( "user_id" , userId ) ;
//		returnPage.setTotal( callRecordDao.selectCount( null ) ) ;
//		EntityWrapper ew = new EntityWrapper() ;
////		ew02.eq( "cr.user_id" , userId ) ;
//		ew.eq( "1" , 1 ) ;
//		ew.orderBy( "callTime" , false ) ;
////		SqlHelper.fillWrapper( selectPage , ew ) ;
//		returnPage.setRecords( callRecordDao.selectMultiInPage( selectPage , ew ) ) ;
//
//		return returnPage ;
//
//	}

	@Override
	public void add(CallRecordAddReqDto req) {

		Phone120 phone = new Phone120() ;
		phone.setNumber( req.getPhoneNumber() ) ;
		phone = phoneDao.selectOne( phone ) ;
		if( phone == null ){
			//不存在则插入
			phone = new Phone120() ;
			phone.setNumber( req.getPhoneNumber() ) ;
			phone.setAscription( req.getAscription() ) ;
			phone.setPhoneType( req.getPhoneType() ) ;
			phoneDao.insert( phone ) ;
		}

		CallRecord120 callRecord = new CallRecord120() ;
		callRecord.setId( UUIDGenerator.generate() ) ;
		callRecord.setPhoneId( phone.getId() ) ;
		callRecord.setUserId( ( (User120) SecurityUtils.getSubject().getPrincipal() ).getId() ) ;
		callRecord.setCallType( req.getCallType() ) ;
		callRecord.setCallTime( new Date( req.getCallTime() ) ) ;
		callRecord.setConnectTime( new Date( req.getConnectTime() ) ) ;
		callRecord.setEndTime( new Date( req.getEndTime() ) ) ;
		callRecord.setTalkTime( req.getTalkTime() ) ;
		callRecord.setHadConnected( req.getHadConnected() ) ;
		callRecord.setBellCount( req.getBellCount() ) ;
		callRecordDao.insert( callRecord ) ;

	}

	/**
	 * 获取今日通话记录列表（只显示当前登录用户的）
	 * @return
	 */
	@Override
	public List<CallRecordBean> today() {

		long userId = ( ( User120 ) SecurityUtils.getSubject().getPrincipal() ).getId() ;
		Calendar calendar = Calendar.getInstance() ;
		calendar.setTime( new Date() ) ;
		calendar.set( Calendar.HOUR_OF_DAY , 0 ) ;
		calendar.set( Calendar.MINUTE , 0 ) ;
		calendar.set( Calendar.SECOND , 0 ) ;
		//获取今日开始结束的时间戳
		long startTime = calendar.getTimeInMillis() ;
		long endTime = startTime+1000*60*60*24 ;

		EntityWrapper ew = new EntityWrapper() ;
		ew.eq( "cr.user_id" , userId ) ;
		ew.between( "cr.call_time" , startTime , endTime ) ;
		ew.orderBy( "callTime" , false ) ;

		return callRecordDao.selectMulti( ew ) ;

	}
}
