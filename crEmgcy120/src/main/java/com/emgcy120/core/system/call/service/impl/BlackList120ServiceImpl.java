package com.emgcy120.core.system.call.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.common.util.StringUtil;
import com.emgcy120.core.system.call.entity.BlackList120;
import com.emgcy120.core.system.call.entity.Phone120;
import com.emgcy120.core.system.call.mapper.BlackList120Mapper;
import com.emgcy120.core.system.call.mapper.Phone120Mapper;
import com.emgcy120.core.system.call.service.IBlackList120Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emgcy120.core.system.call.web.dto.BlackListAddReqDto;
import com.emgcy120.core.system.call.web.dto.BlackListBean;
import com.emgcy120.core.system.call.web.dto.BlackListListReqDto;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import com.emgcy120.core.system.sys.entity.User120;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-21
 */
@Service
public class BlackList120ServiceImpl extends ServiceImpl<BlackList120Mapper, BlackList120> implements IBlackList120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(BlackList120ServiceImpl.class);
	
	@Autowired
	private BlackList120Mapper blackListDao ;
	@Autowired
	private Phone120Mapper phoneDao ;

	@Override
	public Page<BlackListBean> list(BlackListListReqDto req) {

		Page<BlackListBean> returnPage = new Page() ;
		Page<BlackListBean> selectPage = new Page() ;

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
			ew.eq( "bl.phone_id" , phone.getId() ) ;
		}
		String callDate = req.getCallDate() ;
		if( !StringUtil.isEmpty( callDate ) ){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ) ;
			Calendar calendar = new GregorianCalendar() ;
			try {
				calendar.setTime( sdf.parse( "2017-11-24" ) ) ;
			} catch (ParseException e) {
				e.printStackTrace();
				throw new CustomException( ErrorCode.DATA_FORMAT_ERROR ) ;
			}
			long startTime = calendar.getTimeInMillis() ;
			long endTime = startTime+1000*60*60*24 ;
			ew.between( "p.last_time" , startTime , endTime ) ;
		}
		String employeeId = req.getEmployeeId() ;
		if( !StringUtil.isEmpty( employeeId ) ){
			ew.eq( "u.employee_id" , employeeId ) ;
		}
		returnPage.setTotal( blackListDao.countMulti( ew ) ) ;
		//查询结果集
		ew.orderBy( "bl.create_time" , false ) ;
		returnPage.setRecords( blackListDao.selectMultiInPage( selectPage , ew ) ) ;

		return returnPage ;

	}

	@Override
	public void add(BlackListAddReqDto req) {

		String phoneNumber = req.getPhoneNumber() ;

		Phone120 phone = new Phone120() ;
		phone.setNumber( phoneNumber ) ;
		phone = phoneDao.selectOne( phone ) ;
		if( phone == null ){
			phone = new Phone120() ;
			phone.setNumber( phoneNumber ) ;
			phoneDao.insert( phone ) ;
		}

		BlackList120 blackList = new BlackList120() ;
		blackList.setPhoneId( phone.getId() ) ;
		blackList = blackListDao.selectOne( blackList ) ;
		if( blackList != null ){
			//已经加入过黑名单
			throw new CustomException( ErrorCode.BLACKLIST_EXISTED ) ;
		}
		blackList = new BlackList120() ;
		blackList.setPhoneId( phone.getId() ) ;
		blackList.setUserId( ( (User120) SecurityUtils.getSubject().getPrincipal() ).getId() ) ;
		blackList.setCreateTime( new Date() ) ;
		blackListDao.insert( blackList ) ;

	}

    @Override
    public void addList(List<BlackListAddReqDto> reqDtos) {
        if (CollectionUtils.isNotEmpty(reqDtos)) {
            Set<BlackList120> blackList120Set = Sets.newHashSet();
            reqDtos.stream().forEach(r -> {
                BlackList120 black = new BlackList120();
                Phone120 phone = new Phone120();
                phone.setNumber( r.getPhoneNumber() ) ;
                phone = phoneDao.selectOne( phone ) ;
                if( phone == null ){
                    phone = new Phone120() ;
                    phone.setNumber( r.getPhoneNumber() ) ;
                    phoneDao.insert(phone);
                }
                black.setPhoneId(phone.getId());
                if( blackListDao.selectOne( black ) == null ){
//                    black.setUserId(ShiroUserUtil.getCurrentUser().getId());
                    black.setCreateTime(new Date());
                    blackList120Set.add(black);
                }
            });
            if (CollectionUtils.isNotEmpty(blackList120Set))
                this.insertBatch(Lists.newArrayList(blackList120Set));
        }else
            throw new CustomException(123,"没有需要添加的黑名单");
    }

    public static void main( String[] args ) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ) ;

		Calendar calendar = new GregorianCalendar() ;
		calendar.setTime( sdf.parse( "2017-11-24" ) ) ;
		System.out.println( calendar.getTimeInMillis() ) ;



	}

}
