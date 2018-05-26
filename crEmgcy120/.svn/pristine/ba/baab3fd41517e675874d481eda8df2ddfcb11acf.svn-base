package com.emgcy120.core.common.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.subversion.core.SubVersion;

/**
 * <p>
 * mybatis plus 代码自动生成工具类
 * </p>
 * 
 * @author chenshuzhuo
 * @date 2017-10-18
 */
public class MpGenerator {

	
	//数据库配置
//    private static String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/cr_emgcy?characterEncoding=utf8";
    private static String JDBC_URL = "jdbc:mysql://192.168.1.20:3306/cr_emgcy?characterEncoding=utf8";
    
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String JDBC_USERNAME = "root";
    private static String JDBC_PASSWORD = "123456";
    
    // 生成的包路径
    private static String PACKAGEDIR = "com.emgcy120.core.system";
    
 // xml 生成路径
    private static String MYBATIS_XML = System.getProperty("user.dir")+"/src/main/resources/mybatis/";
	
    
    /**
	 * <p>
	 * 跟据数据库表自动生成java代码和mapper文件
	 * </p>
	 * 
	 */
	public static void main(String[] args) {
		//生成test表
		String[] tabArr=new String[] {"cr_attachment_120"};
		//模块名称
		String moduleName="attachment";
		
		execute(moduleName, tabArr);
	}
	
	/**
	 * 执行
	 * @param  moduleName 模块名
	 * @param  tabArr 生成的表
	 */
	private static void execute(String moduleName,String[] tabArr){

		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);
		gc.setBaseResultMap(true);
		gc.setBaseColumnList(true);
		gc.setOpen(false);
		gc.setAuthor(SubVersion.getInstance().getCurrentConnectName());
		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		// gc.setMapperName("%sDao");
		// gc.setXmlName("%sDao");
		// gc.setServiceName("MP%sService");
		// gc.setServiceImplName("%sServiceDiy");
		// gc.setControllerName("%sAction");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert() {
			// 自定义数据库表字段类型转换【可选】
			@Override
			public DbColumnType processTypeConvert(String fieldType) {
				System.out.println("转换类型：" + fieldType);
				// 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
				return super.processTypeConvert(fieldType);
			}
		});
		dsc.setDriverName(JDBC_DRIVER);
		dsc.setUsername(JDBC_USERNAME);
		dsc.setPassword(JDBC_PASSWORD);
		dsc.setUrl(JDBC_URL);
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
		strategy.setTablePrefix(new String[] { "cr_", "sys_" });// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setInclude(tabArr); // 需要生成的表
		strategy.setLogicDeleteFieldName("del_flag");
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表
		// 自定义实体父类
//		 strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
		// 自定义实体，公共字段
//		 strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// 自定义 mapper 父类
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// 自定义 service 父类
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// 自定义 service 实现类父类
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// 自定义 controller 父类
		// strategy.setSuperControllerClass("com.baomidou.demo.TestController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setRemarkName(String name) {this.name = name; return this;}
		// strategy.setEntityBuilderModel(true);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent(PACKAGEDIR);
		pc.setModuleName(moduleName);
		mpg.setPackageInfo(pc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};

		// 自定义 xxList.jsp 生成
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		/*focList.add(new FileOutConfig("/template/list.jsp.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return "D://my_" + tableInfo.getEntityName() + ".jsp";
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);*/

		// 调整 xml 生成目录演示
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return MYBATIS_XML + tableInfo.getEntityName() + "Mapper.xml";
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 关闭默认 xml 生成，调整生成 至 根目录
//		TemplateConfig tc = new TemplateConfig();
//		tc.setXml(null);
//		mpg.setTemplate(tc);

		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
		// 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		 TemplateConfig tc = new TemplateConfig();
//		 tc.setController("/template/controller.java.vm");
		 tc.setEntity("/template/entity.java.vm");
		 tc.setMapper("/template/mapper.java.vm");
		 tc.setXml(null);
		 tc.setService("/template/service.java.vm");
		 tc.setServiceImpl("/template/serviceImpl.java.vm");
//		 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
		 mpg.setTemplate(tc);

		// 执行生成
		mpg.execute();

		// 打印注入设置【可无】
//		System.err.println(mpg.getCfg().getMap().get("abc"));
	
	}
	
	

}