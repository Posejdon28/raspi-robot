package esb.rest.healthcheck;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.constraints.NotBlank;

@Controller("/health-check")
@Validated
public class HealthCheckController {

    @Get(uri = "/health-check/{name}")
    @Operation(summary = "Checks server health", description = "return server up status")
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @Tag(name = "health-check")
    public Single<HealthCheckResponse> healthCheck(@NotBlank @Parameter(description = "system name to check connection with") String name) {
        return Single.just(new HealthCheckResponse(name + "-ok"));
    }
}

