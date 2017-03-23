/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.base;

import cn.joylau.mybatis.mapper.common.base.insert.InsertMapper;
import cn.joylau.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface BaseInsertMapper<T> extends
        InsertMapper<T>,
        InsertSelectiveMapper<T> {

}