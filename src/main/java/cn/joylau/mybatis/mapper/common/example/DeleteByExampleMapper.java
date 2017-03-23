/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.example;

import cn.joylau.mybatis.mapper.provider.ExampleProvider;
import org.apache.ibatis.annotations.DeleteProvider;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface DeleteByExampleMapper<T> {

    /**
     * 根据Example条件删除数据
     *
     * @param example
     * @return
     */
    @DeleteProvider(type = ExampleProvider.class, method = "dynamicSQL")
    int deleteByExample(Object example);

}