package com.lichkin.framework.springboot.configurations;

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
import org.springframework.context.annotation.Lazy;
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
@EnableJpaRepositories(enableDefaultTransactions = false, entityManagerFactoryRef = "primaryLocalContainerEntityManagerFactoryBean", transactionManagerRef = "primaryPlatformTransactionManager", basePackages = { "com.lichkin.**.daos.impl" })
public class LKSpringBootConfiguration4DBPrimary {

	/** 数据源 */
	@Autowired
	@Qualifier("primaryDataSource")
	@Lazy
	private DataSource dataSource;

	/** JPA配置属性 */
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


	/**
	 * 定义实体类管理对象
	 * @param builder 实体类管理对象工厂
	 * @return 实体类管理对象
	 */
	@Primary
	@Bean(name = "primaryEntityManager")
	public EntityManager primaryEntityManager(final EntityManagerFactoryBuilder builder) {
		return primaryLocalContainerEntityManagerFactoryBean(builder).getObject().createEntityManager();
	}


	/**
	 * 配置实体类管理对象工厂
	 * @param builder 实体类管理对象工厂
	 * @return 实体类管理对象工厂
	 */
	@Primary
	@Bean(name = "primaryLocalContainerEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean primaryLocalContainerEntityManagerFactoryBean(final EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).properties(jpaProperties.getHibernateProperties(dataSource)).packages("com.lichkin.**.entities.impl").persistenceUnit("primaryPersistenceUnit").build();
	}


	/**
	 * 定义事务管理对象
	 * @param builder 实体类管理对象工厂
	 * @return 事务管理对象
	 */
	@Primary
	@Bean(name = "primaryPlatformTransactionManager")
	public PlatformTransactionManager primaryPlatformTransactionManager(final EntityManagerFactoryBuilder builder) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager(primaryLocalContainerEntityManagerFactoryBean(builder).getObject());
		return transactionManager;
	}

}
