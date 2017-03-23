/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common.base;

import cn.joylau.mybatis.mapper.common.base.select.*;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface BaseSelectMapper<T> extends
        SelectOneMapper<T>,
        SelectMapper<T>,
        SelectAllMapper<T>,
        SelectCountMapper<T>,
        SelectByPrimaryKeyMapper<T>,
        ExistsWithPrimaryKeyMapper<T> {

}