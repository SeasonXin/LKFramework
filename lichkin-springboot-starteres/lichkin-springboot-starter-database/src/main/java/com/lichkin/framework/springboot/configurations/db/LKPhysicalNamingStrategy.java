package com.lichkin.framework.springboot.configurations.db;

import java.util.Locale;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * Entity映射命名策略，驼峰命名规则，并以T_开头。
 * 例：
 *
 * <pre>
 * T_USER      =&gt; UserEntity
 * T_USER_DEPT =&gt; UserDeptEntity
 * </pre>
 *
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public class LKPhysicalNamingStrategy implements PhysicalNamingStrategy {

	/** 表名前缀 */
	private static final String TABLE_PREFIX = "T_";

	/** 表名后缀 */
	private static final String TABLE_SUFFIX = "_ENTITY";


	@Override
	public Identifier toPhysicalCatalogName(final Identifier name, final JdbcEnvironment jdbcEnvironment) {
		return name;
	}


	@Override
	public Identifier toPhysicalSchemaName(final Identifier name, final JdbcEnvironment jdbcEnvironment) {
		return name;
	}


	@Override
	public Identifier toPhysicalTableName(final Identifier name, final JdbcEnvironment jdbcEnvironment) {
		if (name == null) {
			return null;
		}

		String str = LKPhysicalNamingStrategy.addUnderscores(name.getText());
		if (!str.startsWith(LKPhysicalNamingStrategy.TABLE_PREFIX)) {
			str = LKPhysicalNamingStrategy.TABLE_PREFIX + str;
		}
		if (str.endsWith(LKPhysicalNamingStrategy.TABLE_SUFFIX)) {
			str.replace(LKPhysicalNamingStrategy.TABLE_SUFFIX, "");
		}

		return Identifier.toIdentifier(str);
	}


	@Override
	public Identifier toPhysicalSequenceName(final Identifier name, final JdbcEnvironment jdbcEnvironment) {
		return name;
	}


	@Override
	public Identifier toPhysicalColumnName(final Identifier name, final JdbcEnvironment jdbcEnvironment) {
		if (name == null) {
			return null;
		}
		return Identifier.toIdentifier(LKPhysicalNamingStrategy.addUnderscores(name.getText()));
	}


	protected static String addUnderscores(String name) {
		if (name.endsWith("Entity")) {
			name = name.substring(0, name.length() - "Entity".length());
		}

		final StringBuilder buf = new StringBuilder(name);
		for (int i = 1; i < buf.length(); i++) {
			if (Character.isLowerCase(buf.charAt(i - 1)) && Character.isUpperCase(buf.charAt(i))) {
				buf.insert(i++, '_');
			}
		}

		return buf.toString().toUpperCase(Locale.ROOT);
	}

}
