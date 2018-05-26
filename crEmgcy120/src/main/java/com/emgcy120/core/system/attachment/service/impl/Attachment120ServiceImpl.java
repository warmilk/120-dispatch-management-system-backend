package com.emgcy120.core.system.attachment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.emgcy120.core.common.config.AppConfig;
import com.emgcy120.core.common.constants.Constant;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.common.util.AttachmentUtils;
import com.emgcy120.core.common.util.MD5Util;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.attachment.entity.Attachment120;
import com.emgcy120.core.system.attachment.mapper.Attachment120Mapper;
import com.emgcy120.core.system.attachment.service.IAttachment120Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.emgcy120.core.system.sys.entity.User120;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 120调度中心附件表 服务实现类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-26
 */
@Service
public class Attachment120ServiceImpl extends ServiceImpl<Attachment120Mapper, Attachment120> implements IAttachment120Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Attachment120ServiceImpl.class);

	@Autowired
	AttachmentUtils attachmentUtils ;
	@Autowired
	AppConfig appConfig ;

	@Autowired
	private Attachment120Mapper attachment120Dao;

	@Override
	public ReturnMap saveFile(MultipartFile multipartFile, String newFileName, String remark)
		throws Exception {

		if (StringUtils.isBlank(newFileName)) {
			newFileName = multipartFile.getOriginalFilename();
		}
		//文件后缀
		String suffix = attachmentUtils.getFileDotSuffix( newFileName ) ;

		//要存储的文件路径
		String filePath = attachmentUtils.getFileUploadPath(newFileName);
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		//缓存的文件
		File tempFile = new File(filePath + File.separator + newFileName);
		multipartFile.transferTo(tempFile);

		//要增加的记录
		Attachment120 insertAttachment = new Attachment120() ;
		insertAttachment.setFileName( newFileName ) ;
		insertAttachment.setFileType( attachmentUtils.getFileType(newFileName) ) ;
		insertAttachment.setSize( multipartFile.getSize() ) ;
		insertAttachment.setCreateBy( ( ( User120 ) SecurityUtils.getSubject().getPrincipal() ).getId() ) ;
		insertAttachment.setCreateTime( new Date() ) ;
		insertAttachment.setEnable( 1 ) ;
		insertAttachment.setRemark( remark ) ;

		//获取文件md5，以检查文件是否已经上传过
		String fileMd5 = MD5Util.getMD5(tempFile);
		Attachment120 selectAttachment = new Attachment120() ;
		selectAttachment.setMd5( fileMd5 ) ;
//		Attachment120 oldAttachment = attachment120Dao.selectOne( selectAttachment ) ;
		EntityWrapper<Attachment120> selectAttachmentEw = new EntityWrapper<>( selectAttachment ) ;
		List<Attachment120> oldAttachmentList = attachment120Dao.selectList( selectAttachmentEw ) ;
		Attachment120 oldAttachment = null ;
		if( oldAttachmentList != null && oldAttachmentList.size() > 0 ){
			oldAttachment = oldAttachmentList.get( 0 ) ;
		}
		if( oldAttachment != null && attachmentUtils.getFileDotSuffix( oldAttachment.getFileName() ).equals( suffix ) ){
			//该文件已经上传过且后缀一样
			tempFile.delete() ;
			insertAttachment.setPath( oldAttachment.getPath() ) ;
		}
		else{
			//该文件没有上传过
			//真正保存的文件
			String saveFile = filePath + File.separator + fileMd5 +suffix;
			File newFile = new File(saveFile);
			if (newFile.exists()) {
				newFile.delete() ;
			}
			tempFile.renameTo(newFile);
			insertAttachment.setPath( attachmentUtils.getSaveFileTypePath(newFileName) ) ;
		}

		insertAttachment.setMd5( fileMd5 ) ;
		insertAttachment.setDownloadUrl( appConfig.getHostURI()+insertAttachment.getPath()
				+insertAttachment.getMd5()+suffix ) ;

		// 保存数据库
		attachment120Dao.insert( insertAttachment ) ;

		return ReturnMap.ok()
				.put( Constant.KEY_ATTACHMENT_ID , insertAttachment.getId() )
				.put( Constant.KEY_DOWNLOAD_URL , insertAttachment.getDownloadUrl() )
				;

	}

}
