/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common;

import cn.joylau.mybatis.mapper.common.base.BaseDeleteMapper;
import cn.joylau.mybatis.mapper.common.base.BaseInsertMapper;
import cn.joylau.mybatis.mapper.common.base.BaseSelectMapper;
import cn.joylau.mybatis.mapper.common.base.BaseUpdateMapper;

/**
 * 通用Mapper接口,其他接口继承该接口即可
 * @param <T> 不能为空
 */
public interface BaseMapper<T> extends
        BaseSelectMapper<T>,
        BaseInsertMapper<T>,
        BaseUpdateMapper<T>,
        BaseDeleteMapper<T> {

}