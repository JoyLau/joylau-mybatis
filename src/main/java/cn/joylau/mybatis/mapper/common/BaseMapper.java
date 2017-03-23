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
 * <p/>
 * <p>这是一个例子，自己扩展时可以参考</p>
 * <p/>
 * <p>项目地址 : <a href="https://github.com/abel533/Mapper" target="_blank">https://github.com/abel533/Mapper</a></p>
 *
 * @param <T> 不能为空
 * @author liuzh
 */
public interface BaseMapper<T> extends
        BaseSelectMapper<T>,
        BaseInsertMapper<T>,
        BaseUpdateMapper<T>,
        BaseDeleteMapper<T> {

}