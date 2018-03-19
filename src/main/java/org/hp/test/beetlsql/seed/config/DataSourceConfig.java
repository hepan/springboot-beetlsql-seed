package org.hp.test.beetlsql.seed.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author hepan
 * @create 2018-03-18 下午1:21
 **/
@Configuration

public class DataSourceConfig {
    @Bean("dataSource")     //声明其为Bean实例
    @Primary
    public DataSource datasource(Environment env) {

        System.out.println("###########"+env.getProperty("spring.datasource.url"));

        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }
}
