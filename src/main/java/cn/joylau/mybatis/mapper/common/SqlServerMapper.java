/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common;


import cn.joylau.mybatis.mapper.common.sqlserver.InsertMapper;
import cn.joylau.mybatis.mapper.common.sqlserver.InsertSelectiveMapper;

/**
 * 通用Mapper接口,SqlServerMapper独有的通用方法
 * @param <T> 不能为空
 */
public interface SqlServerMapper<T> extends
        InsertMapper<T>,
        InsertSelectiveMapper<T> {

}