/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.page.dialect.helper;

import cn.joylau.page.Page;
import cn.joylau.page.dialect.AbstractHelperDialect;
import org.apache.ibatis.cache.CacheKey;

/**
 */
public class HsqldbDialect extends AbstractHelperDialect {

    @Override
    public String getPageSql(String sql, Page page, CacheKey pageKey) {
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 20);
        sqlBuilder.append(sql);
        if (page.getPageSize() > 0) {
            sqlBuilder.append(" LIMIT ");
            sqlBuilder.append(page.getPageSize());
            pageKey.update(page.getPageSize());
        }
        if (page.getStartRow() > 0) {
            sqlBuilder.append(" OFFSET ");
            sqlBuilder.append(page.getStartRow());
            pageKey.update(page.getStartRow());
        }
        return sqlBuilder.toString();
    }
}
