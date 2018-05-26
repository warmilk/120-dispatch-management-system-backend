package com.emgcy120.core.system.staff.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.util.DateUtil;
import com.emgcy120.core.common.util.StringUtil;
import com.emgcy120.core.system.org.mapper.OrgMapper;
import com.emgcy120.core.system.staff.entity.User;
import com.emgcy120.core.system.staff.mapper.UserMapper;
import com.emgcy120.core.system.staff.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emgcy120.core.system.staff.web.dto.StaffListItemBean;
import com.emgcy120.core.system.staff.web.dto.StaffListReqDto;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userDao;
	@Autowired
	private OrgMapper orgDao ;

	@Override
	public Page list(StaffListReqDto req) {

		Page<StaffListItemBean> returnPage = new Page() ;
		Page<StaffListItemBean> selectPage = new Page() ;

		selectPage.setCurrent( req.getPageIndex() ) ;
		selectPage.setSize( req.getPageSize() ) ;

		EntityWrapper ew = new EntityWrapper() ;
		ew.where( "1=1" ) ;
		ew.eq( "u.org_hospital_id" , req.getHospId() ) ;
		if( !StringUtil.isEmpty( req.getName() ) ){
			ew.eq( "u.name" , req.getName() ) ;
		}
		if( 0 != req.getSex() ){
			ew.eq( "u.sex" , req.getSex() ) ;
		}
		if( !StringUtil.isEmpty( req.getPhone() ) ){
			ew.eq( "u.phone" , req.getPhone() ) ;
		}
		if( !StringUtil.isEmpty( req.getDepartment() ) ){
			ew.eq( "o.name" , req.getDepartment() ) ;
		}
		if( !StringUtil.isEmpty( req.getPosition() ) ){
			ew.eq( "u.position" , req.getPosition() ) ;
		}
		//查询全部记录数
		returnPage.setTotal( userDao.countMulti( ew ) ) ;
		//查询结果集
		ew.orderBy( "u.employee_id" , true ) ;
		List<StaffListItemBean> staffList = userDao.selectMultiInPage( selectPage , ew ) ;

		returnPage.setRecords( staffList ) ;

		return returnPage ;

	}

	@Override
	public Map info(long id) {

		User user = userDao.selectById( id ) ;
		if( user == null ){
			throw new CustomException( ErrorCode.STAFF_NOT_EXISTED ) ;
		}

		Map<String,Object> returnMap = new HashMap() ;
		returnMap.put( "staffId" , user.getId() ) ;
		returnMap.put( "name" , user.getName() ) ;
		returnMap.put( "sex" , user.getSex() ) ;
		if( user.getBirthday() != null ) {
			returnMap.put("age", DateUtil.getAge( user.getBirthday() ) ) ;
		}
		returnMap.put( "expert" , ( user.getExpert() != null && user.getExpert() == 1 ) ? true : false ) ;
		returnMap.put( "hospital" , orgDao.selectById( user.getOrgHospitalId() ).getName() ) ;
		returnMap.put( "employeeId" , user.getEmployeeId() ) ;
		returnMap.put( "department" , orgDao.selectById( user.getOrgDeptId() ).getName() ) ;
		returnMap.put( "jobTitle" , user.getJobTitle() ) ;
		returnMap.put( "position" , user.getPosition() ) ;
		returnMap.put( "phone" , user.getPhone() ) ;
		returnMap.put( "email" , user.getEmail() ) ;
		returnMap.put( "photo" , user.getPhoto() ) ;
		returnMap.put( "summary" , user.getSummary() ) ;
		returnMap.put( "major" , user.getMajor() ) ;

		return returnMap ;

	}
}
