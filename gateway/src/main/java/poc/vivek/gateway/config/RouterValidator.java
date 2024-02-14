package poc.vivek.gateway.config;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/api/users/register",
            "/api/auth/login"
    );

    public Predicate<String> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(request::contains);

}