package esb.rest.robot;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller("/api/v1/robot")
public class RobotController {

    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @Get(value = "/local-ip")
    @Tag(name = "robot")
    public HttpResponse getLocalIp() throws IOException, ExecutionException, InterruptedException {
        String ip = IOUtils.toString(Runtime.getRuntime().exec("hostname - I").getInputStream(), "UTF-8");
        robotService.storeResult(new Result(ip));
        return HttpResponse.ok(ip);
    }

    @Get(value = "/public-ip")
    @Tag(name = "robot")
    public HttpResponse getPublicIp() throws IOException, ExecutionException, InterruptedException {
        String ip = IOUtils.toString(Runtime.getRuntime().exec("curl ifconfig.me").getInputStream(), "UTF-8");
        robotService.storeResult(new Result(ip));
        return HttpResponse.ok(ip);
    }
}
