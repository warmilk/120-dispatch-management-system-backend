package com.emgcy120.core.common.util;

import com.emgcy120.core.common.config.AppConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

/**
 * 
 * @author chenshuzhuo
 * @date 2017-12-16
 *
 */
@Component
public class AttachmentUtils {

	private static final Logger logger = LoggerFactory.getLogger(AttachmentUtils.class);

//	private static ApplicationYmlConfig appConfig = SpringContextHolder.getBean(ApplicationYmlConfig.class);

	@Autowired
	AppConfig appConfig ;
	

	/**
	 * 上传服务器文件的路径
	 * @return
	 */
	public String getServerFileSavePath(){
		return appConfig.getResourceRootPath() ;
	}
	/**
	 * 获取文件后缀
	 * 
	 * <pre>
	 * AttachmentUtils.getSuffix("xxxxx.txt") = txt
	 * </pre>
	 * 
	 * @param fileName
	 * @return
	 */
	public String getFileSuffix(String fileName) {
		return getFileSuffix(fileName, true);
	}

	/**
	 * 获取文件后缀
	 * 
	 * <pre>
	 * AttachmentUtils.getSuffix("xxxxx.txt")  = .txt
	 * </pre>
	 * 
	 * @param fileName
	 * @return
	 */
	public String getFileDotSuffix(String fileName) {
		return getFileSuffix(fileName, false);
	}
	
	/**
	 * 获取上传路径
	 * <pre>
	 * AttachmentUtils.getFileUploadPath("1.txt") = D:\ user\doc\20171206\
	 * </pre>
	 * @return 服务器路径+文件名称对应的文件夹+当前日期
	 */
	public String getFileUploadPath(String fileName){
		return getServerFileSavePath()+File.separator+getSaveFileTypePath(fileName);
	}
	
	/**
	 * 获取文件类型
	 * <pre>
	 * 根据文件返回文件类型
	 * (-1:错误，
	 * 1:文档,
	 * 2:压缩文件,
	 * 3:图片,
	 * 4:语音文件,
	 * 5:视频文件,
	 * 6:报表文件,
	 * 0:未知)
	 * </pre>
	 * @param fileName
	 * @return
	 */
	public Integer getFileType(String fileName) {

		if(StringUtils.isBlank(fileName)){
			logger.warn("file name not is blank !");
			return null;
		}
		return getFileTypeBySuffix(getFileSuffix(fileName));

	}
	
	/**
	 * 根据文件的名称获取数据保存的文件类型路径
	 * <pre>
	 * 	getSaveFileTypePath("1.txt")  = \doc\20171206\
	 * </pre>
	 * @param fileName
	 * @return 文件名称对应的文件夹+当前日期
	 */
	public String getSaveFileTypePath(String fileName){

		if(StringUtils.isBlank(fileName)){
			logger.warn("file name not is blank !");
			return null;
		}
		String relativeSavePathByFileType = getRelativeSavePathByFileType(getFileType(fileName));
		return File.separator + relativeSavePathByFileType+ File.separator+DateUtil.formatDate(new Date(), "yyyyMMdd")
				+ File.separator;
		
	}
	

	/**
	 * @param fileName
	 * @param flag
	 * @return
	 */
	private String getFileSuffix(String fileName, boolean flag) {
		if (StringUtils.isBlank(fileName)) {
			logger.warn("file name not is blank !");
			return "" ;
		}
		int lastIndexOf = fileName.lastIndexOf(".");
		if (lastIndexOf == -1) {
			logger.warn("file name not suffix !");
			return "" ;
		}
		if (flag) {
			lastIndexOf++;
		}
		return fileName.substring(lastIndexOf).toLowerCase();
	}

	/**
	 * 根据fileType来分类文件保存的相对路径
	 *
	 * @param fileType
	 * @return
	 */
	public String getRelativeSavePathByFileType(int fileType) {
		switch (fileType) {
			case 1:
				return "doc";
			case 2:
				return "tar";
			case 3:
				return "image";
			case 4:
				return "sound";
			case 5:
				return "video";
			case 6:
				return "report";
			case 7:
				return "dcm";
			default:
				return "other";
		}
	}

	/**
	 * 根据文件后缀返回文件类型(1:文档,2:压缩文件,3:图片,4:语音文件,5:视频文件,6:报表文件,0:未知)
	 *
	 * @param suffix
	 * @return
	 */
	public int getFileTypeBySuffix(String suffix) {
		suffix = suffix.toLowerCase();
		if ("txt".equals(suffix)){
			return 1;
		}
		if ("doc".equals(suffix)){
			return 1;
		}
		if ("docx".equals(suffix)){
			return 1;
		}
		if ("wps".equals(suffix)){
			return 1;
		}
		if ("ppt".equals(suffix)){
			return 1;
		}
		if ("pptx".equals(suffix)){
			return 1;
		}
		if ("xls".equals(suffix)){
			return 1;
		}
		if ("xlsx".equals(suffix)){
			return 1;
		}
		if ("pdf".equals(suffix)){
			return 1;
		}
		if ("rar".equals(suffix)){
			return 2;
		}
		if ("zip".equals(suffix)){
			return 2;
		}
		if ("7z".equals(suffix)){
			return 2;
		}
		if ("gif".equals(suffix)){
			return 3;
		}
		if ("jpg".equals(suffix)){
			return 3;
		}
		if ("jpeg".equals(suffix)){
			return 3;
		}
		if ("bmp".equals(suffix)){
			return 3;
		}
		if ("png".equals(suffix)){
			return 3;
		}
		if ("tif".equals(suffix)){
			return 3;
		}
		if ("pic".equals(suffix)){
			return 3;
		}
		if ("wav".equals(suffix)){
			return 4;
		}
		if ("mp3".equals(suffix)){
			return 4;
		}
		if ("ra".equals(suffix)){
			return 4;
		}
		if ("mid".equals(suffix)){
			return 4;
		}
		if ("cda".equals(suffix)){
			return 4;
		}
		if ("aif".equals(suffix)){
			return 4;
		}
		if ("mp4".equals(suffix)){
			return 4;
		}
		if ("flv".equals(suffix)){
			return 5;
		}
		if ("avi".equals(suffix)){
			return 5;
		}
		if ("swf".equals(suffix)){
			return 5;
		}
		if ("mov".equals(suffix)){
			return 5;
		}
		if ("mpg".equals(suffix)){
			return 5;
		}
		if ("rm".equals(suffix)){
			return 5;
		}
		if ("asf".equals(suffix)){
			return 5;
		}
		if ("mkv".equals(suffix)){
			return 5;
		}
		if ("jasper".equals(suffix)){
			return 6;
		}
		if ("dcm".equals(suffix)){
			return 7;
		}
		return 0;
	}

}
