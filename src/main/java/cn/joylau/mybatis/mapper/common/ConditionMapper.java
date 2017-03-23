/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common;


import cn.joylau.mybatis.mapper.common.condition.*;

/**
 * 通用Mapper接口,Condition查询
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface ConditionMapper<T> extends
        SelectByConditionMapper<T>,
        SelectCountByConditionMapper<T>,
        DeleteByConditionMapper<T>,
        UpdateByConditionMapper<T>,
        UpdateByConditionSelectiveMapper<T> {

}