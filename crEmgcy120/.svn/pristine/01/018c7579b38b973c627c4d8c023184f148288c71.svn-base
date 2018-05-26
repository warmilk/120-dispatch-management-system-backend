package com.emgcy120.core.system.base;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
	
	public void insert(T t) throws Exception;
	
	public void update(T t) throws Exception;
	
	public void updateBySelective(T t) throws Exception;
	
	public void delete(Long ids) throws Exception;
	
	public T selectById(Long id) throws Exception;
	
	public Integer selectByModelCount(BaseModel  map) throws Exception;
	
	public Integer selectByMapCount(Map  map) throws Exception;
	
	public List<T> selectByModel(BaseModel model) throws Exception;
	
	public List<T> selectByMap(Map  map) throws Exception;
	
	
	
}
