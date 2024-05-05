package pro.developia.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Publisher {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.startFlux()
                .subscribe(System.out::println);

        publisher.startMono()
                .subscribe();

        publisher.startMono2()
                .subscribe();
    }

    public Flux<Integer> startFlux() {
//        Flux.just(1, 2, 3, 4, 5);
        return Flux.range(1, 10).log();
//        Flux.fromIterable(List.of("a","b","c"))
    }

    public Flux<String> startFlux2() {
        return Flux.fromIterable(List.of("a", "b", "c", "d")).log();
    }

    public Mono<Integer> startMono() {
        return Mono.just(1).log();
    }

    public Mono<?> startMono2() {
        return Mono.empty().log();
    }

    public Mono<?> startMono3() {
        return Mono.error(new Exception("hello reactor"));
    }
}
