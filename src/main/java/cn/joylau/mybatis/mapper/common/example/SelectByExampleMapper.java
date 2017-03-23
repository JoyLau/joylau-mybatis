/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.example;

import cn.joylau.mybatis.mapper.provider.ExampleProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface SelectByExampleMapper<T> {

    /**
     * 根据Example条件进行查询
     *
     * @param example
     * @return
     */
    @SelectProvider(type = ExampleProvider.class, method = "dynamicSQL")
    List<T> selectByExample(Object example);

}