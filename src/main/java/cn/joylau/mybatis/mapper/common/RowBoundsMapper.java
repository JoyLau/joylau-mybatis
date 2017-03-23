/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common;

import cn.joylau.mybatis.mapper.common.rowbounds.SelectByExampleRowBoundsMapper;
import cn.joylau.mybatis.mapper.common.rowbounds.SelectRowBoundsMapper;

/**
 * 通用Mapper接口,带RowBounds参数的查询
 * <p/>
 * 配合分页插件PageHelper可以实现物理分页
 * <p/>
 * PageHelper - http://git.oschina.net/free/Mybatis_PageHelper
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface RowBoundsMapper<T> extends
        SelectByExampleRowBoundsMapper<T>,
        SelectRowBoundsMapper<T> {

}