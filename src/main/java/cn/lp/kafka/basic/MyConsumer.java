package cn.lp.kafka.basic;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class MyConsumer {
    private final static String TOPIC_NAME = "my-replicated-topic";
    private final static String CONSUMER_GROUP_NAME = "testGroup";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.111.140:9092");
// 消费分组名
        props.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP_NAME);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //设置手动提交
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        //设置
//        props.put(ConsumerConfig.RETRIES_CONFIG, 3);
//        props.put(ConsumerConfig.RETRY_BACKOFF_MS_CONFIG, 1000);
//创建一个消费者的客户端
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
// 消费者订阅主题列表
        consumer.subscribe(Arrays.asList(TOPIC_NAME));

        while (true) {
            /*
             * poll() API 是拉取消息的⻓轮询
             */
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("收到消息：partition = %d,offset = %d, key =%s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
// 手动同步提交offset，当前线程会阻塞直到offset提交成功
// 一般使用同步提交，因为提交之后一般也没有什么逻辑代码了
                if(records.count()>0){
                    consumer.commitSync();
                }
            }
        }
    }
}

