package com.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * User: Kyll
 * Date: 2018-10-09 08:43
 */
@MapperScan(basePackages = "com.dao.gffldev", sqlSessionTemplateRef = "gffldevSqlSessionTemplate")
@Configuration
public class GfFldevMybatisConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(GfFldevMybatisConfig.class);

    @Bean
    public SqlSessionFactory gffldevSqlSessionFactory(@Qualifier("gffldevDataSource") DataSource dataSource) {
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = new Resource[0];
        try {
            resources = pathMatchingResourcePatternResolver.getResources("classpath:dao/gffldev/**/*.xml");
        } catch (IOException e) {
            LOGGER.info(e.getMessage(), e);
        }

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(resources);

        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
            return null;
        }
    }

    @Bean
    public SqlSessionTemplate gffldevSqlSessionTemplate(@Qualifier("gffldevSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
