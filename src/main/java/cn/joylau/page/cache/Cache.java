/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.page.cache;

/**
 * Simple cache interface
 *
 */
public interface Cache<K, V> {

    V get(K key);

    void put(K key, V value);
}
