package aws.hack.ci.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "aws.hack.ci")
@EnableAutoConfiguration
@EntityScan(basePackages = {"aws.hack.ci"})
public class RepositoryConfig {

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
    lef.setDataSource(dataSource);
    lef.setJpaVendorAdapter(jpaVendorAdapter);
    lef.setPackagesToScan("aws.hack.ci");
    lef.setJpaProperties(additionalProperties());
    return lef;
  }

  @Bean
  public DriverManagerDataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("todo");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres");
    return dataSource;
  }

  @Bean
  public HibernateJpaVendorAdapter jpaVendorAdapter() {
    return new HibernateJpaVendorAdapter();
  }

//  @Bean
//  public JpaTransactionManager jpaTransactionManager(EntityManagerFactory factory) {
//    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//    jpaTransactionManager.setEntityManagerFactory(factory);
//    return jpaTransactionManager;
//  }

  Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    return properties;
  }
}
