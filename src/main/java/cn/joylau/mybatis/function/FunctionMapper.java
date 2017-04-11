/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.function;

import cn.joylau.mybatis.mapper.common.IdsMapper;
import cn.joylau.mybatis.mapper.common.Mapper;
import cn.joylau.mybatis.mapper.common.MySqlMapper;

/**
 * Created by JoyLau on 4/6/2017.
 * cn.joylau.mybatis.mapper.function
 * 2587038142.liu@gmail.com
 * FunctionMapper集成了MySQL所使用的绝大部分Mapper了，也可以很好的进行扩展
 */
public interface FunctionMapper<T> extends Mapper<T>, MySqlMapper<T>,IdsMapper<T> {
}
