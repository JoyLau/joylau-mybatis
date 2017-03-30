/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.base.delete;

import cn.joylau.mybatis.mapper.provider.base.BaseDeleteProvider;
import org.apache.ibatis.annotations.DeleteProvider;

/**
 * 通用Mapper接口,删除
 *
 * @param <T> 不能为空
 */
public interface DeleteByPrimaryKeyMapper<T> {

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key
     * @return
     */
    @DeleteProvider(type = BaseDeleteProvider.class, method = "dynamicSQL")
    int deleteByPrimaryKey(Object key);

}