/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.example;

import cn.joylau.mybatis.mapper.provider.ExampleProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface SelectCountByExampleMapper<T> {

    /**
     * 根据Example条件进行查询总数
     *
     * @param example
     * @return
     */
    @SelectProvider(type = ExampleProvider.class, method = "dynamicSQL")
    int selectCountByExample(Object example);

}