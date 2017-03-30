/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.mapper.common;

/**
 * joylau
 * 基础Mapper
 * 该接口的多继承可以很容易的扩展实现其他需要的功能
 * 特别注意，该接口不能被扫描到，否则会出错,这也正是我把包名改为basedao的原因
 * 该接口通过多继承以实现底层不同的功能，但需要注意的是Mapper里面的泛型<>实体类需要有唯一的@id注解</>
 * 一般可以通过继承BaseEntity,或者在实体id上加上注解
 * 要想实现更多的功能可以在baseMapper里面添加方法，然后实现；也可以通过继承更多的Mapper来实现
 * 另外注意自定义实现的方法名不要和继承的Mapper里面的方法名重复
 */
public interface JoyLauMapper<T> extends Mapper<T>, MySqlMapper<T>,IdsMapper<T> {

}