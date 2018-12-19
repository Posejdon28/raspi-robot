package esb.rest.robot;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.reactivex.Single;

@KafkaClient("robot-client")
public interface RobotClient {

    @Topic("robot")
    Single<Result> send(@KafkaKey String resultKey, Result result);
}
