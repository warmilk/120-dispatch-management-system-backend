package com.emgcy120.core.system.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.common.util.DateUtil;
import com.emgcy120.core.common.util.PasswordGenerator;
import com.emgcy120.core.common.util.StringUtil;
import com.emgcy120.core.common.util.TokenGenerator;
import com.emgcy120.core.system.sys.entity.PwdApply120;
import com.emgcy120.core.system.sys.entity.User120;
import com.emgcy120.core.system.sys.mapper.PwdApply120Mapper;
import com.emgcy120.core.system.sys.mapper.User120Mapper;
import com.emgcy120.core.system.sys.service.IPwdApply120Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emgcy120.core.system.sys.web.dto.PwdApplyApplyReqDto;
import com.emgcy120.core.system.sys.web.dto.PwdApplyListItemBean;
import com.emgcy120.core.system.sys.web.dto.PwdApplyListReqDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-15
 */
@Service
public class PwdApply120ServiceImpl extends ServiceImpl<PwdApply120Mapper, PwdApply120> implements IPwdApply120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(PwdApply120ServiceImpl.class);
	
	@Autowired
	private PwdApply120Mapper pwdApply120Dao;
	@Autowired
	private User120Mapper user120Dao ;

	@Override
	public Page list(PwdApplyListReqDto req) {

		Page<PwdApplyListItemBean> returnPage = new Page() ;
		Page<PwdApplyListItemBean> selectPage = new Page() ;

		selectPage.setCurrent( req.getPageIndex() ) ;
		selectPage.setSize( req.getPageSize() ) ;

		EntityWrapper ew = new EntityWrapper() ;
		ew.where( "1=1" ) ;
		if( req.getCheckResult() != null && req.getCheckResult() != Constant.PWD_APPLY_CHECK_RESULT_ALL ){
			ew.eq( "check_result" , req.getCheckResult() ) ;
		}
		if( !StringUtil.isEmpty( req.getApplyDate() ) ){
			ew.like( "apply_time" , req.getApplyDate()+"%" ) ;
		}
		//查询全部记录数
		returnPage.setTotal( pwdApply120Dao.selectCount( ew ) ) ;
		//查询结果集
		ew.orderBy( "apply_time" , false ) ;
		List<PwdApply120> selectList = pwdApply120Dao.selectPage( selectPage , ew ) ;
		List<PwdApplyListItemBean> userList = new ArrayList<>() ;
		if( selectList != null ){
			PwdApplyListItemBean bean ;
			PwdApply120 pa ;
			Iterator<PwdApply120> ite = selectList.iterator() ;
			while( ite.hasNext() ){
				pa = ite.next() ;
				bean = new PwdApplyListItemBean() ;
				bean.makeByPwdApply120( pa ) ;
				userList.add( bean ) ;
			}
		}

		returnPage.setRecords( userList ) ;

		return returnPage ;

	}

	@Override
	public Map info(long id) {

		PwdApply120 pa = pwdApply120Dao.selectById( id ) ;
		if( pa == null ){
			//重置密码申请记录不存在
			throw new CustomException( ErrorCode.PWD_APPLY_NOT_EXISTED ) ;
		}
//		User120 user = new User120() ;
//		user.setEmail( pa.getEmail() ) ;
//		user = user120Dao.selectOne( user ) ;
//		if( user == null ){
//			//用户不存在
//			throw new CustomException( ErrorCode.USER_NOT_EXISTED ) ;
//		}

		Map<String,Object> returnMap = new HashMap() ;
		returnMap.put( "pwdApplyId" , pa.getId() ) ;
		returnMap.put( "email" , pa.getEmail() ) ;
		returnMap.put( "checkEmail" , ( pa.getCheckEmail() == 1 ) ? true : false ) ;
		returnMap.put( "phone" , pa.getPhone() ) ;
		returnMap.put( "checkPhone" , ( pa.getCheckPhone() == 1 ) ? true : false ) ;
		returnMap.put( "name" , pa.getName() ) ;
		returnMap.put( "checkName" , ( pa.getCheckName() == 1 ) ? true : false ) ;
		returnMap.put( "employeeId" , pa.getEmployeeId() ) ;
		returnMap.put( "checkEmployeeId" , ( pa.getCheckEmployeeId() == 1 ) ? true : false ) ;
		returnMap.put( "processResult" , pa.getProcessResult() ) ;

		return returnMap ;

	}

	@Override
	@Transactional
	public void recoverPwd(long id) {

		PwdApply120 pa = pwdApply120Dao.selectById( id ) ;
		if( pa == null ){
			//重置密码申请记录不存在
			throw new CustomException( ErrorCode.PWD_APPLY_NOT_EXISTED ) ;
		}
		User120 user = new User120() ;
		user.setEmail( pa.getEmail() ) ;
		user = user120Dao.selectOne( user ) ;
		if( user == null ){
			//用户不存在
			throw new CustomException( ErrorCode.USER_NOT_EXISTED ) ;
		}

		Date date = new Date() ;

		//修改用户密码为初始密码
		String newPwd = PasswordGenerator.getRandomPassword() ;
		String salf = RandomStringUtils.randomAlphanumeric(20) ;
		String encryptedPwd = TokenGenerator.entryptPassword( newPwd, salf ) ;
		user.setSalt( salf ) ;
		user.setPassword( encryptedPwd ) ;
		user.setModifier( ( ( User120 ) SecurityUtils.getSubject().getPrincipal() ).getId() ) ;
		user.setModifyTime( date ) ;
		user120Dao.updateById( user ) ;

		//修改申请记录的处理结果
		pa.setProcessResult( Constant.PWD_APPLY_PROCESS_RESULT_INIT );
		pa.setProcessTime( date ) ;
		pwdApply120Dao.updateById( pa ) ;

	}

	/**
	 * 忽略重置密码申请
	 * @param id
	 */
	@Override
	public void ignore(long id) {

		PwdApply120 pa = pwdApply120Dao.selectById( id ) ;
		if( pa == null ){
			//重置密码申请记录不存在
			throw new CustomException( ErrorCode.PWD_APPLY_NOT_EXISTED ) ;
		}

		//修改申请记录的处理结果
		pa.setProcessResult( Constant.PWD_APPLY_PROCESS_RESULT_IGNORE );
		pa.setProcessTime( new Date() ) ;
		pwdApply120Dao.updateById( pa ) ;

	}

	@Override
	public void apply(PwdApplyApplyReqDto req) {

		User120 user = new User120() ;
		user.setEmail( req.getEmail() ) ;
		user = user120Dao.selectOne( user ) ;
		if( user == null ){
			throw new CustomException( ErrorCode.USER_NOT_EXISTED ) ;
		}

		PwdApply120 pa = new PwdApply120() ;
		pa.setEmail( req.getEmail() ) ;
		pa.setPhone( req.getPhone() ) ;
		pa.setName( req.getName() ) ;
		pa.setEmployeeId( req.getEmployeeId() ) ;
		pa.setProcessResult( Constant.PWD_APPLY_PROCESS_RESULT_WAIT );
		pa.setApplyTime( new Date() ) ;

		int checkResult = Constant.PWD_APPLY_CHECK_RESULT_OK ;
		//校验邮箱
		if( req.getEmail().equals( user.getEmail() ) ){
			pa.setCheckEmail( Constant.PWD_APPLY_CHECK_RESULT_OK ) ;
		}
		else{
			pa.setCheckEmail( Constant.PWD_APPLY_CHECK_RESULT_WRONG ) ;
			checkResult = Constant.PWD_APPLY_CHECK_RESULT_WRONG ;
		}
		//校验号码
		if( req.getPhone().equals( user.getPhone() ) ){
			pa.setCheckPhone( Constant.PWD_APPLY_CHECK_RESULT_OK ) ;
		}
		else{
			pa.setCheckPhone( Constant.PWD_APPLY_CHECK_RESULT_WRONG ) ;
			checkResult = Constant.PWD_APPLY_CHECK_RESULT_WRONG ;
		}
		//校验姓名
		if( req.getName().equals( user.getName() ) ){
			pa.setCheckName( Constant.PWD_APPLY_CHECK_RESULT_OK ) ;
		}
		else{
			pa.setCheckName( Constant.PWD_APPLY_CHECK_RESULT_WRONG ) ;
			checkResult = Constant.PWD_APPLY_CHECK_RESULT_WRONG ;
		}
		//校验工号
		if( req.getEmployeeId().equals( user.getEmployeeId() ) ){
			pa.setCheckEmployeeId( Constant.PWD_APPLY_CHECK_RESULT_OK ) ;
		}
		else{
			pa.setCheckEmployeeId( Constant.PWD_APPLY_CHECK_RESULT_WRONG ) ;
			checkResult = Constant.PWD_APPLY_CHECK_RESULT_WRONG ;
		}
		pa.setCheckResult( checkResult ) ;

		pwdApply120Dao.insert( pa ) ;

	}
}
