package esb.rest.robot;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class RobotListener {

    @Topic("robot")
    public void receive(@KafkaKey String key, Result result) {
        System.out.println("Got Result - " + result.getResult() + " by key:" + key);
    }
}
