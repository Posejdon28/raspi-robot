package esb.rest.orders;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.reactivex.Single;

@KafkaClient("order-client")
public interface OrderClient {

    @Topic("orders")
    Single<Order> send(@KafkaKey String orderKey, Order order);
}
