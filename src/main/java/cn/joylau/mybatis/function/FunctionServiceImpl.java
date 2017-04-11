/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.function;

import cn.joylau.page.PageHelper;
import cn.joylau.page.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by JoyLau on 4/6/2017.
 * cn.joylau.mybatis.mapper.function
 * 2587038142.liu@gmail.com
 * 详细说明见接口注释
 * 该抽象类提供了获取mapper的方法，由此方法，可以进行很方便的扩展，你懂得~~
 */
public abstract class FunctionServiceImpl<T> implements FunctionService<T> {

    @Autowired
    protected FunctionMapper<T> mapper;

    public FunctionMapper<T> getFunctionMapper() {
        return mapper;
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     */
    @Override
    public int insert(T model) {
        return mapper.insert(model);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     */
    @Override
    public int insertSelective(T model) {
        return mapper.insertSelective(model);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 批量插入，支持批量插入的数据库可以使用，另外该接口限制实体包含`id`属性并且必须为自增列
     */
    @Override
    public int insertList(List<T> list) {
        return mapper.insertList(list);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键更新实体全部字段，null值会被更新
     */
    @Override
    public int updateByPrimaryKey(T model) {
        return mapper.updateByPrimaryKey(model);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键更新属性不为null的值
     */
    @Override
    public int updateByPrimaryKeySelective(T model) {
        return mapper.updateByPrimaryKeySelective(model);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件更新实体`model`包含的全部属性，null值会被更新
     */
    @Override
    public int updateByExample(T model, Object example) {
        return mapper.updateByExample(model, example);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件更新实体`model`包含的不是null的属性值
     */
    @Override
    public int updateByExampleSelective(T model, Object example) {
        return mapper.updateByExampleSelective(model, example);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体属性作为条件进行删除，查询条件使用等号
     */
    @Override
    public int delete(T model) {
        return mapper.delete(model);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体id删除
     */
    @Override
    public int deleteById(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件删除数据
     */
    @Override
    public int deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     *
     * @param ids 如 "1,2,3,4"
     */
    @Override
    public int deleteByIds(String ids) {
        return mapper.deleteByIds(ids);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     */
    @Override
    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体中的属性值进行查询，查询条件使用等号
     */
    @Override
    public List<T> select(T model) {
        return mapper.select(model);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体中的id查询实体
     */
    @Override
    public T selectById(int id) {
        return selectByPrimaryKey(id);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 查询全部结果
     */
    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件进行查询
     */
    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据example条件和RowBounds进行分页查询
     */
    @Override
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return mapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     *
     * @param ids 如 "1,2,3,4"
     */
    @Override
    public List<T> selectByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     */
    @Override
    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体中的属性查询总数，查询条件使用等号
     */
    @Override
    public int selectCount(T model) {
        return mapper.selectCount(model);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件进行查询总数
     */
    @Override
    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     */
    @Override
    public T selectOne(T model) {
        return mapper.selectOne(model);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体属性和RowBounds进行分页查询
     */
    @Override
    public List<T> selectByRowBounds(T model, RowBounds rowBounds) {
        return mapper.selectByRowBounds(model, rowBounds);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 单表分页查询
     */
    @Override
    public PageInfo selectPage(int pageNum, int pageSize, T model) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = select(model);
        return new PageInfo<>(list);
    }

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件进行分页查询
     */
    @Override
    public PageInfo selectPageByExample(int pageNum, int pageSize, Object example) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = selectByExample(example);
        return new PageInfo<>(list);
    }
}
