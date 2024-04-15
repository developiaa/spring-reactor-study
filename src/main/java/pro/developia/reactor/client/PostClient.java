package pro.developia.reactor.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pro.developia.reactor.dto.PostResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PostClient {
    private final WebClient webClient;
    private final String url = "http://localhost:8090";

    // webclient -> mvc("/posts/{id}")
    public Mono<PostResponse> getPost(Long id) {
        String uriString = UriComponentsBuilder.fromHttpUrl(url)
                .path("/posts/%d".formatted(id))
                .buildAndExpand()
                .toUriString();

        return webClient.get()
                .uri(uriString)
                .retrieve()
                .bodyToMono(PostResponse.class);
    }
}
