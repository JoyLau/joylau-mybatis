/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.util;

import cn.joylau.mybatis.mapper.MapperException;
import cn.joylau.mybatis.mapper.entity.Example;
import cn.joylau.mybatis.mapper.entity.IDynamicTableName;

/**
 * OGNL静态方法
 *
 */
public abstract class OGNL {

    /**
     * 校验通用 Example 的 entityClass 和当前方法是否匹配
     *
     * @param parameter
     * @param entityFullName
     * @return
     */
    public static boolean checkExampleEntityClass(Object parameter, String entityFullName) {
        if (parameter != null && parameter instanceof Example && StringUtil.isNotEmpty(entityFullName)) {
            Example example = (Example) parameter;
            Class<?> entityClass = example.getEntityClass();
            if(!entityClass.getCanonicalName().equals(entityFullName)){
                throw new MapperException("当前 Example 方法对应实体为:" + entityFullName
                        + ", 但是参数 Example 中的 entityClass 为:" + entityClass.getCanonicalName());
            }
        }
        return true;
    }

    /**
     * 是否包含自定义查询列
     *
     * @param parameter
     * @return
     */
    public static boolean hasSelectColumns(Object parameter) {
        if (parameter != null && parameter instanceof Example) {
            Example example = (Example) parameter;
            if (example.getSelectColumns() != null && example.getSelectColumns().size() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否包含自定义 Count 列
     *
     * @param parameter
     * @return
     */
    public static boolean hasCountColumn(Object parameter) {
        if (parameter != null && parameter instanceof Example) {
            Example example = (Example) parameter;
            return StringUtil.isNotEmpty(example.getCountColumn());
        }
        return false;
    }

    /**
     * 是否包含 forUpdate
     *
     * @param parameter
     * @return
     */
    public static boolean hasForUpdate(Object parameter) {
        if (parameter != null && parameter instanceof Example) {
            Example example = (Example) parameter;
            return example.isForUpdate();
        }
        return false;
    }

    /**
     * 不包含自定义查询列
     *
     * @param parameter
     * @return
     */
    public static boolean hasNoSelectColumns(Object parameter) {
        return !hasSelectColumns(parameter);
    }

    /**
     * 判断参数是否支持动态表名
     *
     * @param parameter
     * @return true支持，false不支持
     */
    public static boolean isDynamicParameter(Object parameter) {
        if (parameter != null && parameter instanceof IDynamicTableName) {
            return true;
        }
        return false;
    }

    /**
     * 判断参数是否b支持动态表名
     *
     * @param parameter
     * @return true不支持，false支持
     */
    public static boolean isNotDynamicParameter(Object parameter) {
        return !isDynamicParameter(parameter);
    }
}
