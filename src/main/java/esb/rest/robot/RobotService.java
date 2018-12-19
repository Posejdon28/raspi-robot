package esb.rest.robot;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import javax.inject.Singleton;
import java.util.concurrent.ExecutionException;


@Singleton
public class RobotService {

    private final KafkaProducer<String, Result> kafkaProducer;

    public RobotService(@KafkaClient("robot-client") KafkaProducer<String, Result> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    RecordMetadata storeResult(Result result) throws ExecutionException, InterruptedException {
        return kafkaProducer.send(new ProducerRecord<>("robot", "result", result)).get();
    }
}
