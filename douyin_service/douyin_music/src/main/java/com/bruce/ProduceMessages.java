package com.bruce;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class ProduceMessages {

    public static void main(String[] args) {
        // Kafka 服务器地址
        String bootstrapServers = "192.168.200.130:9092";

        // Producer 配置
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            // 发送一条消息到 input-topic
            ProducerRecord<String, String> record = new ProducerRecord<>("input-topic", "key", "Hello Kasssssssssfka Streams");
            producer.send(record).get();
            System.out.println("Message sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
