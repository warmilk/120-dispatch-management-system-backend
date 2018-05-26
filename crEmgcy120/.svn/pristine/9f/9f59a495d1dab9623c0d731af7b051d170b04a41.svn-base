package com.emgcy120.core.system.attachment.web;


import com.emgcy120.core.common.base.BaseMsg;
import com.emgcy120.core.common.constants.ReturnCode;
import com.emgcy120.core.common.enm.ErrorCode;
import com.emgcy120.core.common.exception.CustomException;
import com.emgcy120.core.common.util.AttachmentUtils;
import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.attachment.service.IAttachment120Service;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 120调度中心附件表 前端控制器
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-26
 */
@Controller
@RequestMapping( "/attachment" )
public class AttachmentController {

    @Autowired
    AttachmentUtils attachmentUtils ;

    @Autowired
    IAttachment120Service attachment120Service ;

    @PostMapping("/upload")
    @ResponseBody
    public ReturnMap upload(
            @RequestParam(value = "file") MultipartFile multipartFile,
            @RequestParam(value = "fileName", required = false) String fileName,
            @RequestParam(required = false) String remark ) throws Exception {

        MultipartFile[] multipartFileArr = { multipartFile };
        if (multipartFile.isEmpty()) {
            throw new CustomException( ErrorCode.FILE_IS_EMPTY ) ;
        }
        String realFileName = multipartFile.getOriginalFilename();
        String suffix = attachmentUtils.getFileDotSuffix(realFileName);

        if ( StringUtils.isNotBlank( fileName ) ) {
            fileName = fileName+suffix ;
        } else {
            fileName = realFileName ;
        }

        return attachment120Service.saveFile( multipartFile , fileName , remark ) ;

    }
	
}
