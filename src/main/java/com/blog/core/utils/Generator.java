package com.blog.core.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 15:40 2020/5/10
 */
@SuppressWarnings("ALL")
public class Generator {

    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/blog?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String AUTHOR = "zeyi";
    private static final String PROPERTY = "user.dir";
    private static final String PROJECT_PATH = "/src/main/java";
    private static final String SERVICE_NAME = "%sService";
    private static final String MODULE_NAME = "模块名";
    private static final String PARENT_PACKAGE = "com.blog.modules";
    private static final String COLUMN_NAME = "表名";
    private static final String SERVICE = "service";
    private static final String ENTITY = "entity";
    private static final String MAPPER = "mapper";
    private static final String XML = "mapper";
    private static final String CONTROLLER = "controller";
    private static final String XML_TEMPLATE = "/templates/mapper.xml.ftl";
    private static final String TABLE_PREFIX = "tbl_";
    private static final String SUPER_ENTITY = "com.blog.modules.base.entity.BaseEntity";
    private static final String SUPER_CONTROLLER = "com.blog.modules.base.controller.BaseCrudController";
    private static final String SUPER_MAPPER = "com.blog.modules.base.mapper.MyMapper";
    private static final String SUPER_SERVICE = "com.blog.modules.base.service.MyService";
    private static final String SUPER_SERVICE_IMPL = "com.blog.modules.base.service.impl.BaseServiceImpl";

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //1.全局配置
        String projectPath = System.getProperty(PROPERTY);
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + PROJECT_PATH)
                .setAuthor(AUTHOR)
                .setOpen(false)
                .setFileOverride(true)
                .setServiceName(SERVICE_NAME)
                .setBaseColumnList(true)
                .setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        //2.数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setUrl(URL)
                .setDriverName(MYSQL_DRIVER)
                .setUsername(USERNAME)
                .setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        //3.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setInclude(scanner(COLUMN_NAME))
                .setTablePrefix(TABLE_PREFIX)
                .setSuperEntityClass(SUPER_ENTITY)
                .setSuperControllerClass(SUPER_CONTROLLER)
                .setSuperMapperClass(SUPER_MAPPER)
                .setSuperServiceClass(SUPER_SERVICE)
                .setSuperServiceImplClass(SUPER_SERVICE_IMPL)
                .setEntityLombokModel(true)
                .setSuperEntityColumns(new String[]{"id", "created_by", "created_date", "last_modified_by", "last_modified_date", "version"})
                .setVersionFieldName("version")
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(false);
        mpg.setStrategy(strategy);

        //4.包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner(MODULE_NAME))
                .setParent(PARENT_PACKAGE)
                .setService(SERVICE)
                .setEntity(ENTITY)
                .setMapper(MAPPER)
                .setController(CONTROLLER)
                .setXml(XML);
        mpg.setPackageInfo(pc);

        //5.自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        List<FileOutConfig> foList = new ArrayList<>();
        foList.add(new FileOutConfig(XML_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(foList);
        mpg.setCfg(cfg);

        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        mpg.setTemplate(tc);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入"+ tip + ":");
        System.out.println(help.toString());
        if (scanner.hasNext()){
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

}
