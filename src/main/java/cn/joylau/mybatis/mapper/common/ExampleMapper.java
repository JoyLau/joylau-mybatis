/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common;

import cn.joylau.mybatis.mapper.common.example.*;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface ExampleMapper<T> extends
        SelectByExampleMapper<T>,
        SelectCountByExampleMapper<T>,
        DeleteByExampleMapper<T>,
        UpdateByExampleMapper<T>,
        UpdateByExampleSelectiveMapper<T> {

}