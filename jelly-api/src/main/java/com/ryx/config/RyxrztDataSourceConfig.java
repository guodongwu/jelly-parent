package com.ryx.config;
import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageInterceptor;

import javax.sql.DataSource;


/**
 * @author RYX
 */
@MapperScan(basePackages = "com.ryx.ryxrzt.mapper",sqlSessionFactoryRef ="ryxrztSqlSessionFactory" )
@Configuration
public class RyxrztDataSourceConfig {
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    @Primary
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ryxrztSqlSessionFactory")
    public SqlSessionFactory ryxrztSqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCallSettersOnNulls(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);

        sessionFactoryBean.setConfiguration(configuration);
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/ryxrzt/*.xml"));
//      配置分页插件拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "oracle");
        properties.setProperty("reasonable", "true");
        properties.setProperty("params", "pageNum=pageNum;pageSize=pageSize");
        pageInterceptor.setProperties(properties);
        
        //添加插件
        sessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        return sessionFactoryBean.getObject();
    }
    @Bean(name = "ryxrztTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ryxrztSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("ryxrztSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
