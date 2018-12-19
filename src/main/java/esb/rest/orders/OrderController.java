package esb.rest.orders;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

@Controller("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Post
    @Operation(summary = "Creates an order", description = "returns status with message id")
    @Tag(name = "orders")
    public HttpResponse createOrder(@Body Order order) throws ExecutionException, InterruptedException {
        RecordMetadata recordMetadata = orderService.storeOrder(order);
        return HttpResponse.ok(recordMetadata.timestamp());
    }
}
