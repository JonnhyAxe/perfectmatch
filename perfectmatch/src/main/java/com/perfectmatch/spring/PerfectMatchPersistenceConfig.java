package com.perfectmatch.spring;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
@Configuration
@ComponentScan({ "com.perfectmatch.persistence" })
////@PropertySource({ "classpath:application-${persistenceTarget:mongo}.properties" })
////@EnableJpaRepositories(basePackages = "com.perfectmatch.persistence.dao")
public class PerfectMatchPersistenceConfig {
//
//    @Autowired
//    private Environment env;
//
//   // @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan(new String[] { "com.perfectmatch" });
//        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//        return em;
//    }
//
//    final Properties additionalProperties() {
//
//        final Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
//                env.getProperty("spring.jpa.hibernate.ddl-auto", "create-drop"));
//        hibernateProperties.setProperty("hibernate.dialect",
//                env.getProperty("hibernate.dialect"));
//        hibernateProperties.setProperty("hibernate.driverClassName",
//                env.getProperty("spring.datasource.driver-class-name"));
//
//        // setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
//        // setProperty("hibernate.ejb.naming_strategy",
//        // org.hibernate.cfg.ImprovedNamingStrategy.class.getName());
//        return hibernateProperties;
//    }
//
//    //@Bean
//    public DataSource dataSource() {
//
//        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        return dataSource;
//    }
//
//   //@Bean
//    public JpaTransactionManager transactionManager() {
//
//        final JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }
//
}
