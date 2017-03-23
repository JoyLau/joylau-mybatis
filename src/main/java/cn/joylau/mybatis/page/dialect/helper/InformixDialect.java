/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.page.dialect.helper;

import cn.joylau.mybatis.page.Page;
import cn.joylau.mybatis.page.dialect.AbstractHelperDialect;
import org.apache.ibatis.cache.CacheKey;

/**
 * @author liuzh
 */
public class InformixDialect extends AbstractHelperDialect {

    @Override
    public String getPageSql(String sql, Page page, CacheKey pageKey) {
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 40);
        sqlBuilder.append("SELECT ");
        if (page.getStartRow() > 0) {
            sqlBuilder.append(" SKIP ");
            sqlBuilder.append(page.getStartRow());
            pageKey.update(page.getStartRow());
        }
        if (page.getPageSize() > 0) {
            sqlBuilder.append(" FIRST ");
            sqlBuilder.append(page.getPageSize());
            pageKey.update(page.getPageSize());
        }
        sqlBuilder.append(" * FROM ( ");
        sqlBuilder.append(sql);
        sqlBuilder.append(" ) TEMP_T");
        return sqlBuilder.toString();
    }

}
