/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.provider;

import cn.joylau.mybatis.mapper.mapperhelper.MapperHelper;
import cn.joylau.mybatis.mapper.mapperhelper.MapperTemplate;
import cn.joylau.mybatis.mapper.mapperhelper.SqlHelper;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * SqlServerProvider实现类，特殊方法实现类
 *
 */
public class SqlServerProvider extends MapperTemplate {

    public SqlServerProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 插入
     *
     * @param ms
     */
    public String insert(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.insertColumns(entityClass, true, false, false));
        sql.append(SqlHelper.insertValuesColumns(entityClass, true, false, false));
        return sql.toString();
    }

    /**
     * 插入不为null的字段
     *
     * @param ms
     * @return
     */
    public String insertSelective(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.insertColumns(entityClass, true, true, isNotEmpty()));
        sql.append(SqlHelper.insertValuesColumns(entityClass, true, true, isNotEmpty()));
        return sql.toString();
    }
}
