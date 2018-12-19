package esb;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "ne-int", version = "1.0", description = "Java Integrator API",
                contact = @Contact(url = "http://nowaera.pl", name = "Kamil Uchnast", email = "k.uchnast@nowaera.pl")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}