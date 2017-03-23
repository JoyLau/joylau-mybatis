/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.spring.mapper;

import cn.joylau.mybatis.mapper.mapperhelper.MapperHelper;

/**
 * 增加mapperHelper
 *
 * @param <T>
 * @author liuzh
 */
public class MapperFactoryBean<T> extends org.mybatis.spring.mapper.MapperFactoryBean<T> {

    private MapperHelper mapperHelper;

    public MapperFactoryBean() {
    }

    public MapperFactoryBean(Class<T> mapperInterface) {
        super(mapperInterface);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void checkDaoConfig() {
        super.checkDaoConfig();
        //通用Mapper
        if (mapperHelper.isExtendCommonMapper(getObjectType())) {
            mapperHelper.processConfiguration(getSqlSession().getConfiguration(), getObjectType());
        }
    }

    public void setMapperHelper(MapperHelper mapperHelper) {
        this.mapperHelper = mapperHelper;
    }
}
