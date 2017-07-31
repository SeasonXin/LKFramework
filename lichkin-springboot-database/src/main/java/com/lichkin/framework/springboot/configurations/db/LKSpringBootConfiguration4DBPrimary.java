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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 主数据库配置
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(enableDefaultTransactions = false, entityManagerFactoryRef = "primaryLocalContainerEntityManagerFactoryBean", transactionManagerRef = "primaryPlatformTransactionManager", basePackages = { "com.lichkin.**.daos" })
public class LKSpringBootConfiguration4DBPrimary {

	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource dataSource;

	@Autowired
	private JpaProperties jpaProperties;


	/**
	 * 构建主数据源
	 * @return 数据源
	 */
	@Bean(name = "primaryDataSource")
	@Qualifier(value = "primaryDataSource")
	@ConfigurationProperties(prefix = "lichkin.framework.db.primary")
	@Primary
	public DataSource buildPrimaryDataSource() {
		return DataSourceBuilder.create().build();
	}


	@Primary
	@Bean(name = "primaryEntityManager")
	public EntityManager primaryEntityManager(final EntityManagerFactoryBuilder builder) {
		return primaryLocalContainerEntityManagerFactoryBean(builder).getObject().createEntityManager();
	}


	@Primary
	@Bean(name = "primaryLocalContainerEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean primaryLocalContainerEntityManagerFactoryBean(final EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).properties(jpaProperties.getHibernateProperties(dataSource)).packages("com.lichkin.**.entities").persistenceUnit("primaryPersistenceUnit").build();
	}


	@Primary
	@Bean(name = "primaryPlatformTransactionManager")
	public PlatformTransactionManager primaryPlatformTransactionManager(final EntityManagerFactoryBuilder builder) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager(primaryLocalContainerEntityManagerFactoryBean(builder).getObject());
		return transactionManager;
	}

}
