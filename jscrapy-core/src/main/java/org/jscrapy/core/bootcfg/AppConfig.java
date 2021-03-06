package org.jscrapy.core.bootcfg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cxu on 2016/8/3.
 */
@Configuration
@ConfigurationProperties(locations = "classpath:db.properties", ignoreUnknownFields = true, prefix = "spring.h2.datasource")
public class AppConfig
{

    //    @Bean
//    public DataSource dataSource()
//    {
//        return new EmbeddedDatabaseBuilder().addScript("schema.sql").build();
//    }
//    @Bean
//    public DataSourceTransactionManager transactionManager()
//    {
//        return new DataSourceTransactionManager(dataSource());
//    }
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception
//    {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        return sessionFactory.getObject();
//    }
}