/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.base.select;

import cn.joylau.mybatis.mapper.provider.base.BaseSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SelectAllMapper<T> {

    /**
     * 查询全部结果
     *
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<T> selectAll();
}
