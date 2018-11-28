package com.jelly.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator=new AutoGenerator();
        GlobalConfig config=new GlobalConfig();
        config.setOutputDir("/home/wu/桌面");
        config.setFileOverride(true);
        config.setActiveRecord(false);
        config.setEnableCache(false);
        config.setBaseResultMap(true);
        config.setBaseColumnList(true);

        config.setAuthor("will");

        config.setMapperName("%sDao");
        config.setXmlName("%sMapper");
        config.setServiceName("%sService");
        config.setServiceImplName("%sServiceImpl");
        config.setControllerName("%sController");
        autoGenerator.setGlobalConfig(config);
        //配置数据源
        DataSourceConfig dsc=new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/jelly?useSSL=false");
        dsc.setUsername("root");
        dsc.setPassword("root");
        autoGenerator.setDataSource(dsc);

        StrategyConfig strategy=new StrategyConfig();
        strategy.setTablePrefix(new String("admin_"));
        strategy.setNaming(NamingStrategy.underline_to_camel);


        autoGenerator.setStrategy(strategy);

        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("com.jelly.ssm");
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.execute();
        log.info("ok");
    }
}
