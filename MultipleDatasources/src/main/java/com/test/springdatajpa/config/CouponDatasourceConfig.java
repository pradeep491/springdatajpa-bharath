package com.test.springdatajpa.config;

import com.test.springdatajpa.coupon.entities.Coupon;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@EnableJpaRepositories(entityManagerFactoryRef = "couponEntityManagerFactory",
        transactionManagerRef = "couponTransactionManager", basePackages = {
        "com.test.springdatajpa.coupon"})
@EnableTransactionManagement
@Configuration
public class CouponDatasourceConfig {

    @Primary
    @Bean(name = "couponDataSourceProperties")
    @ConfigurationProperties("spring.datasource-coupon")
    public DataSourceProperties couponDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "couponDataSource")
    public DataSource couponDataSource() {
        return couponDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "couponEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean couponEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        HashMap<String, String> couponJpaProperties = new HashMap<>();
        //couponJpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
        return builder.dataSource(couponDataSource())
                .packages(Coupon.class)
                .persistenceUnit("couponDataSource")
                .properties(new HashMap<>()).build();
    }

    @Primary
    @Bean(name = "couponTransactionManager")
    public PlatformTransactionManager couponTransactionManager(@Qualifier("couponEntityManagerFactory")
                                                                   EntityManagerFactory couponEntityManagerFactory) {
        return new JpaTransactionManager(couponEntityManagerFactory);
    }
}
