package com.example.demoexception_2.service.redis;

public interface RedisService<K, V> {
    V get(K key);
    void delete(K key);
    void put(V value);

}
