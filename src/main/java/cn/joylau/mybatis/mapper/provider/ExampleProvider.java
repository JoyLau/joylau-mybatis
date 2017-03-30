/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.provider;

import cn.joylau.mybatis.mapper.mapperhelper.MapperHelper;
import cn.joylau.mybatis.mapper.mapperhelper.MapperTemplate;
import cn.joylau.mybatis.mapper.mapperhelper.SqlHelper;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * ExampleProvider实现类，基础方法实现类
 *
 */
public class ExampleProvider extends MapperTemplate {

    public ExampleProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 根据Example查询总数
     *
     * @param ms
     * @return
     */
    public String selectCountByExample(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        if(isCheckExampleEntityClass()){
            sql.append(SqlHelper.exampleCheck(entityClass));
        }
        sql.append(SqlHelper.selectCount(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.exampleWhereClause());
        sql.append(SqlHelper.exampleForUpdate());
        return sql.toString();
    }

    /**
     * 根据Example删除
     *
     * @param ms
     * @return
     */
    public String deleteByExample(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        if(isCheckExampleEntityClass()){
            sql.append(SqlHelper.exampleCheck(entityClass));
        }
        sql.append(SqlHelper.deleteFromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.exampleWhereClause());
        return sql.toString();
    }


    /**
     * 根据Example查询
     *
     * @param ms
     * @return
     */
    public String selectByExample(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        //将返回值修改为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder("SELECT ");
        if(isCheckExampleEntityClass()){
            sql.append(SqlHelper.exampleCheck(entityClass));
        }
        sql.append("<if test=\"distinct\">distinct</if>");
        //支持查询指定列
        sql.append(SqlHelper.exampleSelectColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.exampleWhereClause());
        sql.append(SqlHelper.exampleOrderBy(entityClass));
        sql.append(SqlHelper.exampleForUpdate());
        return sql.toString();
    }

    /**
     * 根据Example查询
     *
     * @param ms
     * @return
     */
    public String selectByExampleAndRowBounds(MappedStatement ms) {
        return selectByExample(ms);
    }

    /**
     * 根据Example更新非null字段
     *
     * @param ms
     * @return
     */
    public String updateByExampleSelective(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        if(isCheckExampleEntityClass()){
            sql.append(SqlHelper.exampleCheck(entityClass));
        }
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass), "example"));
        sql.append(SqlHelper.updateSetColumns(entityClass, "record", true, isNotEmpty()));
        sql.append(SqlHelper.updateByExampleWhereClause());
        return sql.toString();
    }

    /**
     * 根据Example更新
     *
     * @param ms
     * @return
     */
    public String updateByExample(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        if(isCheckExampleEntityClass()){
            sql.append(SqlHelper.exampleCheck(entityClass));
        }
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass), "example"));
        sql.append(SqlHelper.updateSetColumns(entityClass, "record", false, false));
        sql.append(SqlHelper.updateByExampleWhereClause());
        return sql.toString();
    }
}
