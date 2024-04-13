package pro.developia.reactor;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class SampleHandler {
    public Mono<ServerResponse> getString(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("hello, functional endpoint");
    }
}
