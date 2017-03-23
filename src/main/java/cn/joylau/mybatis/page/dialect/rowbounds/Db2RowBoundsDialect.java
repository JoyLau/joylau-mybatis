/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.page.dialect.rowbounds;

import cn.joylau.mybatis.page.dialect.AbstractRowBoundsDialect;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.session.RowBounds;

/**
 * db2 基于 RowBounds 的分页
 *
 * @author liuzh
 */
public class Db2RowBoundsDialect extends AbstractRowBoundsDialect {

    @Override
    public String getPageSql(String sql, RowBounds rowBounds, CacheKey pageKey) {
        int startRow = rowBounds.getOffset() + 1;
        int endRow = rowBounds.getOffset() + rowBounds.getLimit();
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 120);
        sqlBuilder.append("SELECT * FROM (SELECT TMP_PAGE.*,ROWNUMBER() OVER() AS ROW_ID FROM ( ");
        sqlBuilder.append(sql);
        sqlBuilder.append(" ) AS TMP_PAGE) WHERE ROW_ID BETWEEN ");
        sqlBuilder.append(startRow);
        sqlBuilder.append(" AND ");
        sqlBuilder.append(endRow);
        pageKey.update(startRow);
        pageKey.update(endRow);
        return sqlBuilder.toString();
    }

}
