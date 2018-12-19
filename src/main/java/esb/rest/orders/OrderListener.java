package esb.rest.orders;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class OrderListener {

    @Topic("orders")
    public void receive(@KafkaKey String key, Order order) {
        System.out.println("Got Order - " + order.getNumber() + " by key:" + key);
    }
}
