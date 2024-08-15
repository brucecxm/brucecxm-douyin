package com.bruce;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class CreateTopics {

    public static void main(String[] args) {
        // Kafka 服务器地址
        String bootstrapServers = "192.168.200.130:9092";

        // 配置 AdminClient
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        // 创建 AdminClient 实例
        try (AdminClient adminClient = AdminClient.create(config)) {
            // 创建 input-topic
            NewTopic inputTopic = new NewTopic("input-topic", 1, (short) 1);
            adminClient.createTopics(Collections.singleton(inputTopic)).all().get();

            // 创建 output-topic
            NewTopic outputTopic = new NewTopic("output-topic", 1, (short) 1);
            adminClient.createTopics(Collections.singleton(outputTopic)).all().get();

            System.out.println("Topics created successfully!");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
