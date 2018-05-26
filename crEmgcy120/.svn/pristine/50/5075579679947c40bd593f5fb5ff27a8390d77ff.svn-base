package ${interfacePackageName};

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.emgcy120.core.system.base.BaseJsonDTO;

/**
 * 
 * <br>
 * <b>功能：</b>给IPad,Android的获取${codeName}信息的接口<br>
 * <b>作者：</b>唐志圣<br>
 * <b>日期：</b> ${currentDate} <br>
 * <b>版权所有：<b>版权所有(C) 2014，www.crsoft.com.cn<br>
 */
@Path("/$!{lowerName}")
@Produces( { MediaType.APPLICATION_JSON })
public interface ${className}WebService {
	
	/**
	 * 测试获取${codeName}信息的接口
	 * @return BaseJsonDTO
	 */
	@GET
	@Path("/test")
	public BaseJsonDTO test(@Context HttpHeaders headers);
	
}
