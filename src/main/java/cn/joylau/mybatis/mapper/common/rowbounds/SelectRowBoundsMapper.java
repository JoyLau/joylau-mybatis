/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.rowbounds;

import cn.joylau.mybatis.mapper.provider.base.BaseSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 通用Mapper接口,查询
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface SelectRowBoundsMapper<T> {

    /**
     * 根据实体属性和RowBounds进行分页查询
     *
     * @param record
     * @param rowBounds
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<T> selectByRowBounds(T record, RowBounds rowBounds);

}