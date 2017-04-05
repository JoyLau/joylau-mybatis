package cn.joylau.mybatis.mapper.function;

import cn.joylau.mybatis.mapper.common.IdsMapper;
import cn.joylau.mybatis.mapper.common.Mapper;
import cn.joylau.mybatis.mapper.common.MySqlMapper;

/**
 * Created by LiuFa on 2017/4/5.
 * cn.joylau.mybatis.mapper.base
 * 得益于Spring项目的强大支持，在Spring4.x后，支持泛型注入，这使得我们封装的更加简单了
 */
public interface FunctionMapper<T> extends Mapper<T>, MySqlMapper<T>,IdsMapper<T> {
}
