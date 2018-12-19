package esb.rest.orders;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import javax.inject.Singleton;
import java.util.concurrent.ExecutionException;

@Singleton
public class OrderService {

    private final KafkaProducer<String, Order> kafkaProducer;

    public OrderService(@KafkaClient("order-client") KafkaProducer<String, Order> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    RecordMetadata storeOrder(Order order) throws ExecutionException, InterruptedException {
        return kafkaProducer.send(new ProducerRecord<>("orders", "order", order)).get();
    }
}
