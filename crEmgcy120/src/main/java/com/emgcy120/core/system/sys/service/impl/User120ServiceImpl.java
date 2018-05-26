package com.emgcy120.core.system.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.common.util.StringUtil;
import com.emgcy120.core.common.util.TokenGenerator;
import com.emgcy120.core.common.util.UUIDGenerator;
import com.emgcy120.core.system.sys.entity.User120;
import com.emgcy120.core.system.sys.mapper.User120Mapper;
import com.emgcy120.core.system.sys.service.IUser120Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emgcy120.core.system.sys.web.dto.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-11-15
 */
@Service
public class User120ServiceImpl extends ServiceImpl<User120Mapper, User120> implements IUser120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(User120ServiceImpl.class);
	
	@Autowired
	private User120Mapper user120Dao;

	@Override
	public Page list(UserListReqDto req) {

		Page<UserListItemBean> returnPage = new Page() ;
		Page<UserListItemBean> selectPage = new Page() ;

		selectPage.setCurrent( req.getPageIndex() ) ;
		selectPage.setSize( req.getPageSize() ) ;

		EntityWrapper ew = new EntityWrapper() ;
		ew.where( "status != "+Constant.USER_120_STATUS_DELETE ) ;
		if( !StringUtil.isEmpty( req.getName() ) ){
			ew.eq( "name" , req.getName() ) ;
		}
		//查询全部记录数
		returnPage.setTotal( user120Dao.selectCount( ew ) ) ;
		//查询结果集
		ew.orderBy( "employee_id" , true ) ;
		List<User120> selectList = user120Dao.selectPage( selectPage , ew ) ;
		List<UserListItemBean> userList = new ArrayList<>() ;
		if( selectList != null ){
			UserListItemBean bean ;
			User120 user ;
			Iterator<User120> ite = selectList.iterator() ;
			while( ite.hasNext() ){
				user = ite.next() ;
				bean = UserListItemBean.fromUser120( user ) ;
				userList.add( bean ) ;
			}
		}

		returnPage.setRecords( userList ) ;

		return returnPage ;

	}

	@Override
	@Transactional
	public void changeStatus(long id, int status) {

		User120 user = user120Dao.selectById( id ) ;
		if( user == null ){
			//用户不存在
			throw new CustomException(ErrorCode.USER_NOT_EXISTED ) ;
		}
		user.setStatus( status ) ;
		user.setModifier( ( ( User120 ) SecurityUtils.getSubject().getPrincipal() ).getId() ) ;
		user.setModifyTime( new Date() ) ;

		user120Dao.updateById( user ) ;

	}

	@Override
	@Transactional
	public void add(UserAddReqDto req) {

		if( req.getPassword() != null && req.getPassword().length() < Constant.PASSWORD_LENGTH_MIN ){
			//密码位数不足
			throw new CustomException( ErrorCode.LOGIN_PASSWORD_TOO_SHORT) ;
		}

		User120 user = new User120() ;
		String salf = RandomStringUtils.randomAlphanumeric(20) ;
		user.setUuid( UUIDGenerator.generate() ) ;
		user.setName( req.getName() ) ;
		//存储加密后的密码
		user.setPassword( TokenGenerator.entryptPassword( req.getPassword() , salf ) ) ;
		user.setSalt( salf ) ;
//		user.setSex(  ) ;
//		user.setBirthday(  ) ;
		user.setPhone( req.getPhone() ) ;
		user.setEmail( req.getEmail() ) ;
		user.setPhoto( req.getPhoto() ) ;
		user.setStatus( req.getStatus() ) ;
		user.setCreator( ( ( User120 ) SecurityUtils.getSubject().getPrincipal() ).getId() ) ;
		user.setCreateTime( new Date() ) ;

		user120Dao.insert( user ) ;

		//插入成功之后获取id再生成employeeid
		user.setEmployeeId( String.format( "%03d" , user.getId() ) ) ;
		user120Dao.updateById( user ) ;

	}

	@Override
	@Transactional
	public void updateInfo(@Valid UserUpdateReqDto req) {

		if( req.getPassword() != null && req.getPassword().length() < Constant.PASSWORD_LENGTH_MIN ){
			//密码位数不足
			throw new CustomException( ErrorCode.LOGIN_PASSWORD_TOO_SHORT ) ;
		}

		User120 user = user120Dao.selectById( req.getId() ) ;
		if( user == null ){
			//用户不存在
			throw new CustomException(ErrorCode.USER_NOT_EXISTED ) ;
		}
		String salf = RandomStringUtils.randomAlphanumeric(20) ;
		user.setName( req.getName() ) ;
		//存储加密后的密码
		user.setPassword( TokenGenerator.entryptPassword( req.getPassword() , salf ) ) ;
		user.setSalt( salf ) ;
		user.setPhone( req.getPhone() ) ;
		user.setEmail( req.getEmail() ) ;
		user.setPhoto( req.getPhoto() ) ;
		user.setStatus( req.getStatus() ) ;
		user.setModifier( ( ( User120 ) SecurityUtils.getSubject().getPrincipal() ).getId() ) ;
		user.setModifyTime( new Date() ) ;
		//修改过资料之后此字段设置为0
		user.setInitialPwd( 0 ) ;

		user120Dao.updateById( user ) ;

	}

	@Override
	@Transactional
	public void delete(long id) {

		User120 user = user120Dao.selectById( id ) ;
		if( user == null ){
			//用户不存在
			throw new CustomException(ErrorCode.USER_NOT_EXISTED ) ;
		}
		//更改用户状态为删除，而不是真的删除记录
		user.setStatus( Constant.USER_120_STATUS_DELETE ) ;
		user.setModifier( ( ( User120 ) SecurityUtils.getSubject().getPrincipal() ).getId() ) ;
		user.setModifyTime( new Date() ) ;

		user120Dao.updateById( user ) ;

	}

	@Override
	public void changePwd(UserChangePwdReqDto req) {

		if( req.getNewPassword() != null && req.getNewPassword().length() < Constant.PASSWORD_LENGTH_MIN ){
			//密码位数不足
			throw new CustomException( ErrorCode.LOGIN_PASSWORD_TOO_SHORT) ;
		}

		User120 currentUser = ( User120 ) SecurityUtils.getSubject().getPrincipal() ;
		if( currentUser == null ){
			throw new CustomException( ErrorCode.UNDOWN_LOGIN ) ;
		}
		Long currentUserId = currentUser.getId() ;
		User120 user = user120Dao.selectById( currentUserId ) ;
		if( user == null ){
			throw new CustomException( ErrorCode.USER_NOT_EXISTED ) ;
		}

		//验证旧密码
		if( !TokenGenerator.entryptPassword( req.getOldPassword() , user.getSalt() ).equals( user.getPassword() ) ){
			//验证不通过
			throw new CustomException( ErrorCode.OLD_PASSWORD_ERROR ) ;
		}

		String salf = RandomStringUtils.randomAlphanumeric(20) ;
		//存储加密后的密码
		user.setPassword( TokenGenerator.entryptPassword( req.getNewPassword() , salf ) ) ;
		user.setSalt( salf ) ;
		user.setModifier( currentUserId ) ;
		user.setModifyTime( new Date() ) ;

		user120Dao.updateById( user ) ;

	}

	@Override
	public ReturnMap info(Long id) {

		User120 user = user120Dao.selectById( id ) ;
		if( user == null ){
			throw new CustomException( ErrorCode.USER_NOT_EXISTED ) ;
		}

		return ReturnMap.ok()
				.put( Constant.KEY_USER_ID , user.getId() )
				.put( Constant.KEY_EMPLOYEE_ID, user.getEmployeeId() )
				.put( Constant.KEY_EMAIL , user.getEmail() )
				.put( Constant.KEY_NAME , user.getName() )
				.put( Constant.KEY_PHONE , user.getPhone() )
				.put( Constant.KEY_PHOTO , user.getPhoto() )
				.put( Constant.KEY_STATUS , user.getStatus() )
				;

	}

	@Override
	public Set<String> getRoles(Long userId) {

		Set<String> roleSet = new HashSet<>() ;

		List<String> roleList = user120Dao.getRoles( userId ) ;
		for( String role : roleList ){
			roleSet.add( role ) ;
		}

		return roleSet ;

	}

}
