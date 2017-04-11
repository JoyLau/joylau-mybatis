/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.function;

/**
 * Created by JoyLau on 4/6/2017.
 * cn.joylau.mybatis.mapper.function
 * 2587038142.liu@gmail.com
 */
public abstract class FunctionController {

    /**
     * 获取Session
     */
    public abstract Object getSession();

    /**
     * 获取request.getContextPath()
     */
    public abstract String getContextPath();
}
