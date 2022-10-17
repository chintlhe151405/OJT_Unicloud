package com.example.demoexception_2.repository.redis.message;

public interface RedisRepository <K, V>{
    V get (K key);
    void delete(K key);
    void put(V value);
}
