package com.bruce.config;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    // 配置 Kafka Streams 的基本设置
    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-app"); // 应用程序 ID
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers); // Kafka 服务器地址
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName()); // 默认键序列化器
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName()); // 默认值序列化器
        return new KafkaStreamsConfiguration(props);
    }

    // 定义 Kafka Streams 处理流
    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, String> stream = streamsBuilder.stream("input-topic"); // 从 input-topic 中读取消息流
        stream.foreach((key, value) -> System.out.println("Key: " + key + " Value: " + value)); // 打印每条消息的键值对信息

        // 对消息进行处理，并输出到 output-topic
        KTable<String, Long> wordCounts = stream
                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+"))) // 将消息值按非字母字符拆分为单词列表
                .groupBy((key, value) -> value) // 按单词分组
                .count(); // 统计每个单词的出现次数

        wordCounts.toStream().to("output-topic"); // 将统计结果输出到 output-topic
        return stream;
    }
}
