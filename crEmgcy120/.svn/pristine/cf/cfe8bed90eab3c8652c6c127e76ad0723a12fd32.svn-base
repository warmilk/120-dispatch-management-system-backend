package ${packageName}.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import ${packageName}.bean.${className};
import ${packageName}.model.${className}Model;
import ${packageName}.service.${className}Service;
 
@Controller
public class ${className}Controller extends MultiActionController{
	
	private final static Logger log= Logger.getLogger(${className}Controller.class);
	
	@Autowired(required=false) private ${className}Service<${className}> ${lowerName}Service; 
	
	// Feild start
	private List<${className}> ${lowerName}List = null;
	private ${className} ${lowerName} = new ${className}();

	
	@RequestMapping("/${lowerName}/list") 
	public ModelAndView list(${className}Model model){
		Map<String,Object> map =new HashMap<String,Object>();
		try{
			${lowerName}List = ${lowerName}Service.selectByModel(model);
			map.put("model",model);
			map.put("resultList",${lowerName}List);
		}catch(Exception e){
			log.error(e);
			return new ModelAndView("error"); //访问WEB-INF/jsp/getError.jsp
		}
		return new ModelAndView("${lowerName}/${lowerName}List",map); //访问WEB-INF/jsp/${lowerName}/${lowerName}List.jsp
	}

	@RequestMapping("/${lowerName}/toadd") 
	public ModelAndView toadd(${className} bean){
		return new ModelAndView("${lowerName}/${lowerName}Edit"); //访问WEB-INF/jsp/${lowerName}/${lowerName}Edit.jsp
	}
	
	@RequestMapping("/${lowerName}/toedit") 
	public ModelAndView toedit(Long ids){
		Map<String,Object> map =new HashMap<String,Object>();
		try{
			${lowerName} = ${lowerName}Service.selectById(ids);	
			//如果记录为空则跳转到错误页面
			if(${lowerName} == null){
				return new ModelAndView("error"); //访问WEB-INF/jsp/getError.jsp
			}
			map.put("bean", ${lowerName});
		}catch(Exception e){
			log.error(e);
			return new ModelAndView("error"); //访问WEB-INF/jsp/getError.jsp
		}
		return new ModelAndView("${lowerName}/${lowerName}Edit",map); //访问WEB-INF/jsp/${lowerName}/${lowerName}Edit.jsp
	}
	
	@RequestMapping("/${lowerName}/save") 
	public ModelAndView save(${className} bean){
		try{
			//判断Id主键是否为空，如果主键不叫Id，请改成你的主键属性名称
			if(bean.getId() != null && bean.getId()> 0){
				//id不为空修改
				${lowerName}Service.updateBySelective(bean);
			}else{
				//设置主键
				//bean.setId(MethodUtil.getInit().getLongId());
				//id为空新增
				${lowerName}Service.insert(bean);
			}
		}catch(Exception e){
			log.error(e);
			return new ModelAndView("error"); //访问WEB-INF/jsp/getError.jsp
		}
		return  list(new ${className}Model());//跳转到list页面
	}

	@RequestMapping("/${lowerName}/deletes") 
	public ModelAndView deletes(Long[] ids){
		try{
			${lowerName}Service.delete(ids);
		}catch(Exception e){
			log.error(e);
			return new ModelAndView("error"); //访问WEB-INF/jsp/getError.jsp
		}
		return  list(new ${className}Model());//跳转到list页面
	}

}
