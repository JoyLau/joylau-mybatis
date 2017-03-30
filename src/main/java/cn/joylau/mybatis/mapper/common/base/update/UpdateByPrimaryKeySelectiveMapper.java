/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.base.update;

import cn.joylau.mybatis.mapper.provider.base.BaseUpdateProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 通用Mapper接口,更新
 * @param <T> 不能为空
 */
public interface UpdateByPrimaryKeySelectiveMapper<T> {

    /**
     * 根据主键更新属性不为null的值
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
    @Options(useCache = false, useGeneratedKeys = false)
    int updateByPrimaryKeySelective(T record);

}