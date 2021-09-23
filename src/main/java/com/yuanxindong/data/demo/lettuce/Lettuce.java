package com.yuanxindong.data.demo.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.support.AsyncConnectionPoolSupport;
import io.lettuce.core.support.AsyncPool;
import io.lettuce.core.support.BoundedPoolConfig;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @author yuanxindong
 * @date 9/23/21  10:16 PM
 */
public class Lettuce {

    public static void main(String[] args) {
        RedisClient client = RedisClient.create();
        // 创建异步连接池
        AsyncPool<StatefulRedisConnection<String, String>> pool = AsyncConnectionPoolSupport.createBoundedObjectPool(
            () -> client.connectAsync(StringCodec.UTF8, RedisURI.create("127.0.0.1", 6380)),

            // 使用默认的连接池配置
            BoundedPoolConfig.create());

        // 从连接池中获取连接
        CompletableFuture<StatefulRedisConnection<String, String>> con = pool.acquire();

        // 异步执行setex命令并返回结果
        CompletionStage<String> result = con.thenCompose(connection -> connection.async().setex("test", 30, "test")
            // 释放连接池获取的连接
            .whenComplete((s, throwable) -> pool.release(connection)));
        // 关闭连接池
        pool.closeAsync();

        // 关闭client
        client.shutdownAsync();


    }

}
