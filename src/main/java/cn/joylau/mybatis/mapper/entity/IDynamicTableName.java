/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.entity;

/**
 * 实现动态表名时，实体类需要实现该接口
 *
 */
public interface IDynamicTableName {

    /**
     * 获取动态表名 - 只要有返回值，不是null和''，就会用返回值作为表名
     *
     * @return
     */
    String getDynamicTableName();
}
