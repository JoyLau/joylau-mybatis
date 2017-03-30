/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.sqlserver;

import cn.joylau.mybatis.mapper.provider.SqlServerProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

/**
 * 通用Mapper接口,插入
 * @param <T> 不能为空
 */
public interface InsertSelectiveMapper<T> {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = SqlServerProvider.class, method = "dynamicSQL")
    int insertSelective(T record);

}