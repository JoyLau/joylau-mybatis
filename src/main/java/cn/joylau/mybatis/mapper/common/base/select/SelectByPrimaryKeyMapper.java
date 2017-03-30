/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.base.select;

import cn.joylau.mybatis.mapper.provider.base.BaseSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 通用Mapper接口,其他接口继承该接口即可
 * @param <T> 不能为空
 */
public interface SelectByPrimaryKeyMapper<T> {

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    T selectByPrimaryKey(Object key);

}