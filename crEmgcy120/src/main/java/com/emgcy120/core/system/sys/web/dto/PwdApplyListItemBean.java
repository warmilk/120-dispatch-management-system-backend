package com.emgcy120.core.system.sys.web.dto;

import com.emgcy120.core.system.sys.entity.PwdApply120;
import lombok.Data;

import java.text.SimpleDateFormat;

/**
 * Created by weijieliao on 2017/12/15.
 */
@Data
public class PwdApplyListItemBean {

    //序号
    private Long id ;
    //申请时间
    private String applyTime ;
    //邮箱
    private String email ;
    //资料校验结果：1、正确，2、错误
    private int checkResult ;

    public void makeByPwdApply120(PwdApply120 pa) {

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ) ;

        this.id = pa.getId() ;
        this.applyTime = sdf.format( pa.getApplyTime() ) ;
        this.email = pa.getEmail() ;
        this.checkResult = pa.getCheckResult() ;

    }
}
