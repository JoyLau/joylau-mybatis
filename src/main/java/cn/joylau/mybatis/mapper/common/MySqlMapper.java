/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common;

import cn.joylau.mybatis.mapper.common.special.InsertListMapper;
import cn.joylau.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

/**
 * 通用Mapper接口,MySql独有的通用方法
 * @param <T> 不能为空
 */
public interface MySqlMapper<T> extends
        InsertListMapper<T>,
        InsertUseGeneratedKeysMapper<T> {

}