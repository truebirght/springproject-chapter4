package kr.or.hoseo.springproject.chapter4.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.CUBRIDDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = "kr.or.hoseo.springproject.chapter4.dao")
public class JpaConfig {
	
	@Autowired
	Environment env;
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("kr.or.hoseo.springproject.chapter4.vo");
        em.setJpaVendorAdapter(jpaVendorAdaper());
        em.afterPropertiesSet();
        return em.getObject();
	}
	
    @Bean
    public JpaVendorAdapter jpaVendorAdaper() {
    	
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        CUBRIDDialect.class.getCanonicalName();
        vendorAdapter.setDatabasePlatform(env.getProperty("jpa.database"));
        vendorAdapter.setShowSql(env.getProperty("jpa.showSql", Boolean.class));
        vendorAdapter.setGenerateDdl(true);
        return vendorAdapter;
    }
    
    @Bean(name="transactionManager")
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }
}
