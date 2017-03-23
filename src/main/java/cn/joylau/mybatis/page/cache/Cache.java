/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.mybatis.page.cache;

/**
 * Simple cache interface
 *
 * @author liuzh
 */
public interface Cache<K, V> {

    V get(K key);

    void put(K key, V value);
}
