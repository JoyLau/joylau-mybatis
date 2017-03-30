/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.base;

import cn.joylau.mybatis.mapper.common.base.update.UpdateByPrimaryKeyMapper;
import cn.joylau.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;

/**
 * 通用Mapper接口,基础查询
 * @param <T> 不能为空
 */
public interface BaseUpdateMapper<T> extends
        UpdateByPrimaryKeyMapper<T>,
        UpdateByPrimaryKeySelectiveMapper<T> {

}