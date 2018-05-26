package com.emgcy120.core.system.attachment.service;

import com.emgcy120.core.common.util.ReturnMap;
import com.emgcy120.core.system.attachment.entity.Attachment120;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 120调度中心附件表 服务类
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-26
 */
public interface IAttachment120Service extends IService<Attachment120> {

    ReturnMap saveFile(MultipartFile multipartFile, String fileName, String remark) throws Exception;

}
