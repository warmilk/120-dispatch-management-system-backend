package com.emgcy120.core.common.mybatis;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.emgcy120.core.common.shiro.ShiroUserUtil;
import com.emgcy120.core.system.sys.entity.User120;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.apache.shiro.SecurityUtils;

import java.util.Date;

/**
 * 处理公共字段
 * @author chenshuzhuo
 * 必须实现元对象处理器接口
 *
 */
public class MyMetaObjectHandler extends MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            Object delFlag = getFieldValByName("delFlag", metaObject);
            if (null == delFlag) {
                setFieldValByName("delFlag",0, metaObject);
            }
        } catch (Exception e) {
        }

        try {
            Object createBy = getFieldValByName("createBy", metaObject);
            if (null == createBy) {
                setFieldValByName("createBy", ( (User120) SecurityUtils.getSubject().getPrincipal() ).getId(), metaObject);
            }
        } catch (Exception e) {
        }
        try {
            Object createTime = getFieldValByName("createTime", metaObject);
            if (null == createTime) {
                setFieldValByName("createTime", new Date(), metaObject);
            }
        } catch (Exception e) {
        }
    }

	@SuppressWarnings("unused")
	@Override
    public void updateFill(MetaObject metaObject) {
    	Object update=null;
    	try {
            update = getFieldValByName("updateBy", metaObject);
            setFieldValByName("updateBy",( ( User120 ) SecurityUtils.getSubject().getPrincipal() ).getId(), metaObject);
        } catch (Exception e) {
        }

        try {
        	Object updateTime = getFieldValByName("updateTime", metaObject);
            setFieldValByName("updateTime", new Date(), metaObject);
        } catch (ReflectionException e) {
        }
    }
}
