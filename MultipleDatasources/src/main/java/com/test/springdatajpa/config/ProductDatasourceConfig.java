package com.test.springdatajpa.config;

import com.test.springdatajpa.product.entities.Product;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "productEntityManagerFactory",
        transactionManagerRef = "productTransactionManager", basePackages = {
        "com.test.springdatajpa.product"})
@EnableTransactionManagement
public class ProductDatasourceConfig {

    @Bean(name = "productDataSourceProperties")
    @ConfigurationProperties("spring.datasource-product")
    public DataSourceProperties productDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "productDataSource")
    public DataSource productDataSource() {
        return productDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "productEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(productDataSource()).packages(Product.class).build();
    }

    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager productTransactionManager(@Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory) {
        return new JpaTransactionManager(productEntityManagerFactory);
    }
}
