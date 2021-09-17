package com.yuanxindong.data.demo.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;

/**
 * @author yuanxindong
 * @date 9/17/21  12:09 AM
 */
public class Redis implements RedisMapper<Tuple2<String,Integer>> {

    @Override
    public RedisCommandDescription getCommandDescription() {
        return null;
    }

    @Override
    public String getKeyFromData(Tuple2<String, Integer> stringIntegerTuple2) {
        return null;
    }

    @Override
    public String getValueFromData(Tuple2<String, Integer> stringIntegerTuple2) {
        return null;
    }

}
