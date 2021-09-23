package com.yuanxindong.data.demo.flink;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import java.util.Properties;


/**
 * @author yuanxindong
 * @date 9/17/21  12:10 AM
 */
public class Kafka {

    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "flink-group");
        String inputTopic = "Shakespeare";
        String outputTopic = "WordCount";

        FlinkKafkaConsumer<String> consumer =
            new FlinkKafkaConsumer<String>(inputTopic, new SimpleStringSchema(), properties);
        DataStream<String> stream = env.addSource(consumer);
        String a = "";

        //使用消费kafka 流式处理消息

    }

}
