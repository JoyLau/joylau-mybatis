/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.rowbounds;

import cn.joylau.mybatis.mapper.provider.ExampleProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 通用Mapper接口,查询
 * @param <T> 不能为空
 */
public interface SelectByExampleRowBoundsMapper<T> {

    /**
     * 根据example条件和RowBounds进行分页查询
     *
     * @param example
     * @param rowBounds
     * @return
     */
    @SelectProvider(type = ExampleProvider.class, method = "dynamicSQL")
    List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

}