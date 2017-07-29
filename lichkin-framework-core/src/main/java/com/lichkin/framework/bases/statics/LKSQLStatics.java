package com.lichkin.framework.bases.statics;

/**
 * SQL静态常量
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
public interface LKSQLStatics {

	/** SELECT */
	public static final String SELECT = "SELECT";

	/** FROM */
	public static final String FROM = "FROM";

	/** AS */
	public static final String AS = "AS";

	/** WHERE */
	public static final String WHERE = "WHERE";

	/** DISTINCT */
	public static final String DISTINCT = "DISTINCT";

	/** AND */
	public static final String AND = "AND";

	/** OR */
	public static final String OR = "OR";

	/** BLANK AS BLANK */
	public static final String BLANKASBLANK = LKStringStatics.STR_BLANK + LKSQLStatics.AS + LKStringStatics.STR_BLANK;

	/** BLANK WHERE BLANK */
	public static final String BLANKWHEREBLANK = LKStringStatics.STR_BLANK + LKSQLStatics.WHERE + LKStringStatics.STR_BLANK;

	/** SELECT BLANK DISTINCT */
	public static final String SELECTBLANKDISTINCT = LKSQLStatics.SELECT + LKStringStatics.STR_BLANK + LKSQLStatics.DISTINCT;

}
