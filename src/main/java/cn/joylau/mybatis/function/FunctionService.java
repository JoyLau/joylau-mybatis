/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.function;

import cn.joylau.page.PageInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by JoyLau on 4/6/2017.
 * cn.joylau.mybatis.mapper.function
 * 2587038142.liu@gmail.com
 * 得益于Spring项目的强大支持，在Spring4.x后，支持泛型注入，这使得我们封装的更加简单了
 * 不必再调用到Mapper层，现在在Service层就可以完美使用，封装了3个插入方法，4个更新方法，5个删除方法，13个查询方法
 * 内容涵盖了单条记录CRUD；根据ID或者属性或者条件CRUD；批量删除，插入；分页查询
 * 现在的分页查询更加简单了，调用selectPage可以进行单表分页查询，调用selectPageByExample可以进行条件分页查询
 */
public interface FunctionService<T> {


    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     */
    int insert(T model);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     */
    int insertSelective(T model);


    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 批量插入，支持批量插入的数据库可以使用，另外该接口限制实体包含`id`属性并且必须为自增列
     */
    int insertList(List<T> list);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键更新实体全部字段，null值会被更新
     */
    int updateByPrimaryKey(T model);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键更新属性不为null的值
     */
    int updateByPrimaryKeySelective(T model);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件更新实体`model`包含的全部属性，null值会被更新
     */
    int updateByExample(T model, Object example);


    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件更新实体`model`包含的不是null的属性值
     */
    int updateByExampleSelective(T model, Object example);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体属性作为条件进行删除，查询条件使用等号
     */
    int delete(T model);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体id删除
     */
    int deleteById(int id);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件删除数据
     */
    int deleteByExample(Object example);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     *
     * @param ids 如 "1,2,3,4"
     */
    int deleteByIds(String ids);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     */
    int deleteByPrimaryKey(Object key);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体中的属性值进行查询，查询条件使用等号
     */
    List<T> select(T model);


    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体中的id查询实体
     */
    T selectById(int id);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 查询全部结果
     */
    List<T> selectAll();

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件进行查询
     */
    List<T> selectByExample(Object example);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据example条件和RowBounds进行分页查询
     */
    List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     *
     * @param ids 如 "1,2,3,4"
     */
    List<T> selectByIds(String ids);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     */
    T selectByPrimaryKey(Object key);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体中的属性查询总数，查询条件使用等号
     */
    int selectCount(T model);


    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件进行查询总数
     */
    int selectCountByExample(Object example);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     */
    T selectOne(T model);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据实体属性和RowBounds进行分页查询
     */
    List<T> selectByRowBounds(T model, RowBounds rowBounds);


    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 单表分页查询
     */
    PageInfo selectPage(int pageNum, int pageSize, T model);

    /**
     * Created by JoyLau on 4/6/2017.
     * 2587038142.liu@gmail.com
     * 根据Example条件进行分页查询
     */
    PageInfo selectPageByExample(int pageNum, int pageSize, Object example);
}
