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
@EnableJpaRepositories(enableDefaultTransactions = false, entityManagerFactoryRef = "secondaryLocalContainerEntityManagerFactoryBean", basePackages = { "com.lichkin.**.dao.impl" })
public class LKSpringBootConfiguration4DBSecondary {

	/** 数据源 */
	@Autowired
	@Qualifier("secondaryDataSource")
	@Lazy
	private DataSource secondaryDataSource;

	/** JPA配置属性 */
	@Autowired
	private JpaProperties secondaryJpaProperties;


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


	/**
	 * 定义实体类管理对象
	 * @param builder 实体类管理对象工厂
	 * @return 实体类管理对象
	 */
	@Bean(name = "secondaryEntityManager")
	public EntityManager secondaryEntityManager(final EntityManagerFactoryBuilder builder) {
		return secondaryLocalContainerEntityManagerFactoryBean(builder).getObject().createEntityManager();
	}


	/**
	 * 配置实体类管理对象工厂
	 * @param builder 实体类管理对象工厂
	 * @return 实体类管理对象工厂
	 */
	@Bean(name = "secondaryLocalContainerEntityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean secondaryLocalContainerEntityManagerFactoryBean(final EntityManagerFactoryBuilder builder) {
		return builder.dataSource(secondaryDataSource).properties(secondaryJpaProperties.getHibernateProperties(secondaryDataSource)).packages("com.lichkin.**.entity.impl").persistenceUnit("secondaryPersistenceUnit").build();
	}


	/**
	 * 定义事务管理对象
	 * @param builder 实体类管理对象工厂
	 * @return 事务管理对象
	 */
	@Bean(name = "secondaryPlatformTransactionManager")
	public PlatformTransactionManager secondaryPlatformTransactionManager(final EntityManagerFactoryBuilder builder) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager(secondaryLocalContainerEntityManagerFactoryBean(builder).getObject());
		return transactionManager;
	}

}
