package com.emgcy120.core.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;

public class BeanUtil extends BeanUtils {

	// Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean  
	public static void transMap2Bean(Map<String, Object> map, Object obj) {

		if( map == null || obj == null ){
			return ;
		}

		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				if (map.containsKey(key)) {
					Object value = map.get(key);
					// 得到property对应的setter方法
					Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

	}

	// Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map  
	public static Map<String, Object> transBean2Map(Object obj) {
		if(obj == null){
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// 过滤class属性  
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
//	public static byte[] addBytes(byte[] data1, byte[] data2) {
//	    byte[] data3 = new byte[data1.length + data2.length];
//	    System.arraycopy(data1, 0, data3, 0, data1.length);
//	    System.arraycopy(data2, 0, data3, data1.length, data2.length);
//	    return data3;
//
//	}
	
    static {  
    	//注册util.date的转换器，即允许BeanUtils.copyProperties时的源目标的util类型的值允许为空  
    	ConvertUtils.register(new DateConvert(), java.util.Date.class);  
    	ConvertUtils.register(new IntegerConverter(null), Integer.class);
    	ConvertUtils.register(new LongConverter(null), Long.class);
    	ConvertUtils.register(new FloatConverter(null), Float.class);
    	ConvertUtils.register(new DoubleConverter(null), Double.class);
    	//      BeanUtilsBean beanUtils = new BeanUtilsBean(ConvertUtils.class,new PropertyUtilsBean());  
    }  

    public static void copyProperties(Object target, Object source){  
    	//支持对日期copy  
    	try {
			BeanUtils.copyProperties(target, source);
		} catch (IllegalAccessException e) {
			; // Should not happen
		} catch (InvocationTargetException e) {
			; // Should not happen
		} 
    } 

}
