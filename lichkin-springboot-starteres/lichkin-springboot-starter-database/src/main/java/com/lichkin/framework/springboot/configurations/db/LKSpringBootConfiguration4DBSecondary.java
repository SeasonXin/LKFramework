package com.lichkin.framework.springboot.configurations.db;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 从数据库配置
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(enableDefaultTransactions = false, entityManagerFactoryRef = "secondaryLocalContainerEntityManagerFactoryBean", basePackages = { "com.lichkin.**.dao" })
public class LKSpringBootConfiguration4DBSecondary {

	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource dataSource;

	@Autowired
	private JpaProperties jpaProperties;


	/**
	 * 构建从数据源
	 * @return 数据源
	 */
	@Bean(name = "secondaryDataSource")
	@Qualifier(value = "secondaryDataSource")
	@ConfigurationProperties(prefix = "lichkin.framework.db.secondary")
	public DataSource buildSecondaryDataSource() {
		return DataSourceBuilder.create().build();
	}


	@Bean(name = "secondaryEntityManager")
	public EntityManager secondaryEntityManager(final EntityManagerFactoryBuilder builder) {
		return secondaryLocalContainerEntityManagerFactoryBean(builder).getObject().createEntityManager();
	}


	@Bean(name = "secondaryLocalContainerEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean secondaryLocalContainerEntityManagerFactoryBean(final EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).properties(jpaProperties.getHibernateProperties(dataSource)).packages("com.lichkin.**.entity").persistenceUnit("secondaryPersistenceUnit").build();
	}


	@Bean(name = "secondaryPlatformTransactionManager")
	public PlatformTransactionManager secondaryPlatformTransactionManager(final EntityManagerFactoryBuilder builder) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager(secondaryLocalContainerEntityManagerFactoryBean(builder).getObject());
		return transactionManager;
	}

}
