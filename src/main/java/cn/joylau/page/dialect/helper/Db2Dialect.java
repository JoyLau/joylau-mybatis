/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.page.dialect.helper;

import cn.joylau.page.Page;
import cn.joylau.page.dialect.AbstractHelperDialect;
import org.apache.ibatis.cache.CacheKey;

/**
 */
public class Db2Dialect extends AbstractHelperDialect {

    @Override
    public String getPageSql(String sql, Page page, CacheKey pageKey) {
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 120);
        sqlBuilder.append("SELECT * FROM (SELECT TMP_PAGE.*,ROWNUMBER() OVER() AS ROW_ID FROM ( ");
        sqlBuilder.append(sql);
        sqlBuilder.append(" ) AS TMP_PAGE) WHERE ROW_ID BETWEEN ");
        sqlBuilder.append(page.getStartRow() + 1);
        sqlBuilder.append(" AND ");
        sqlBuilder.append(page.getEndRow());
        pageKey.update(page.getStartRow() + 1);
        pageKey.update(page.getEndRow());
        return sqlBuilder.toString();
    }

}
