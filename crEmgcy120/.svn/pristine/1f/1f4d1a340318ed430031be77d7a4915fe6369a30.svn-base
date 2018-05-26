package ${interfacePackageName}.impl;

import java.util.Date;
import javax.ws.rs.core.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import com.emgcy120.core.system.base.BaseJsonDTO;

import ${interfacePackageName}.${className}WebService;
import ${packageName}.service.${className}Service;


public class ${className}WebServiceImpl implements ${className}WebService {

	@Autowired private ${className}Service ${lowerName}Ser;
	
	@Override
	public BaseJsonDTO test(HttpHeaders headers) {
		BaseJsonDTO json = new BaseJsonDTO();
		try {
			json.setMsg("测试访问${className}WebServiceImpl类成功，共有("+${lowerName}Ser.selectByModelCount(null)+")条数据");
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
}
