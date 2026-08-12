package com.mvc.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = {"com.mvc"})
public class AppConfig {

	@Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        // Scan all @Entity classes
        sessionFactory.setPackagesToScan("com.mvc.entity");

        Properties props = new Properties();

        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatejee");
        props.put("hibernate.connection.username", "root");
        props.put("hibernate.connection.password", "root");

        props.put("hibernate.current_session_context_class", "thread");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");
        props.put("hibernate.use_sql_comments", "true");

        // With Hibernate 6, you can omit this property because it is detected automatically.
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        sessionFactory.setHibernateProperties(props);

        return sessionFactory;
    }
}
