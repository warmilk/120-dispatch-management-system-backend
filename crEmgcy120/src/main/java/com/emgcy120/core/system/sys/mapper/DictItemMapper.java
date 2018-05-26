package com.emgcy120.core.system.sys.mapper;

import com.emgcy120.core.system.sys.entity.DictItem;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 字典明细表 Mapper 接口
 * </p>
 *
 * @author /Users/weijieliao
 * @since 2017-12-05
 */
public interface DictItemMapper extends BaseMapper<DictItem> {

    List<Map<String,Object>> list( String dictCode ) ;

}