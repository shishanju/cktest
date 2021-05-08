package com.lemon;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

public class CodeGenerator {
	
public static void main(String[] args) {
        // ?????
        AutoGenerator mpg = new AutoGenerator();

        // ????
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("kk");
        gc.setOpen(false);
        gc.setFileOverride(true);

        gc.setServiceName("%sService");//??IXXService?I
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true); //???? Swagger2 ????
        mpg.setGlobalConfig(gc);

        // ?????
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/api-runner?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("12345678");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // ???
        PackageConfig pc = new PackageConfig();     
        pc.setParent("com.lemon");
      // pc.setModuleName("???");
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
     
        pc.setEntity("pojo");
        mpg.setPackageInfo(pc);

        // ?????
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        String templatePath = "/templates/mapper.xml.ftl";
     // ???????
        List<FileOutConfig> focList = new ArrayList<>();
        // ???????????
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // ???????? ? ??? Entity ??????????? xml ????????????
                return projectPath + "/src/main/resources/mapper/" 
                       + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // ???? xml ??
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // ????
        StrategyConfig strategy = new StrategyConfig();
   
        strategy.setInclude("user","test_rule","test_report","suite","project","cases","case_param_value","api_request_param","api_classification","api");//??????????????
     
        strategy.setNaming(NamingStrategy.underline_to_camel);//??????????????
        strategy.setTablePrefix(pc.getModuleName() + "_"); //??????????

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//????????????????
        strategy.setEntityLombokModel(true); // lombok ?? @Accessors(chain = true) setter????

        strategy.setRestControllerStyle(true); //restful api?????
        strategy.setControllerMappingHyphenStyle(false); //url???????
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setStrategy(strategy);
      
       
        // 6???
        mpg.execute();
    }

}