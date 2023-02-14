package cn.lp.kafka.basic;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author lp
 */
public class MyProducer {
    private final static String TOPIC_NAME = "my-replicated-topic";

    public static void main(String[] args) throws CommandLine.ExecutionException, InterruptedException, ExecutionException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.111.140:9092");
//把发送的key从字符串序列化为字节数组
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//把发送消息value从字符串序列化为字节数组
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_NAME, 0, "", "测试");
        //同步发送消息
//        RecordMetadata metadata = producer.send(producerRecord).get();
////=====阻塞=======
//        System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-" + metadata.partition() + "|offset-" + metadata.offset());
        //异步发送消息
        producer.send(producerRecord, (recordMetadata, e) -> {
            if (e != null) {
                System.err.println("发送消息失败：" +
                    e.getStackTrace());
            }
            if (recordMetadata != null) {
                System.out.println("异步方式发送消息结果：" + "topic-" +recordMetadata.topic() + "|partition-"+ recordMetadata.partition() + "|offset-" + recordMetadata.offset());
            }
        });
        producer.close();
    }
}
