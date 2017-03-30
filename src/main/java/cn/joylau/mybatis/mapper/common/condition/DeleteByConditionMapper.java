/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.condition;

import cn.joylau.mybatis.mapper.provider.ConditionProvider;
import org.apache.ibatis.annotations.DeleteProvider;

/**
 * 通用Mapper接口,Condition查询
 * @param <T> 不能为空
 */
public interface DeleteByConditionMapper<T> {

    /**
     * 根据Condition条件删除数据
     *
     * @param condition
     * @return
     */
    @DeleteProvider(type = ConditionProvider.class, method = "dynamicSQL")
    int deleteByCondition(Object condition);

}