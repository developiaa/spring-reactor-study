package pro.developia.reactor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import pro.developia.reactor.repository.User;
import pro.developia.reactor.repository.UserR2dbcRepository;
import pro.developia.reactor.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class UserService {
    //    private final UserRepository userRepository;
    private final UserR2dbcRepository userRepository;
    private final ReactiveRedisTemplate<String, User> reactiveRedisTemplate;

    public Mono<User> create(String name, String email) {
        return userRepository.save(
                User.builder()
                        .name(name)
                        .email(email)
                        .build()
        );
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    private String getUserCacheKey(Long id) {
        return "users:%d".formatted(id);
    }

    public Mono<User> findById(Long id) {
        // 1. redis 조회
        // 2. 값이 존재하면 응답을 하고
        // 3. 없으면 DB에 질의하고 그 결과를 redis에 저장
        return reactiveRedisTemplate.opsForValue()
                .get(getUserCacheKey(id))
                .switchIfEmpty(
                        userRepository.findById(id)
                                .flatMap(u -> reactiveRedisTemplate.opsForValue()
                                        .set(getUserCacheKey(id), u, Duration.ofSeconds(30))
                                        .then(Mono.just(u))
                                )
                );

//        return userRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id) {
        return userRepository.deleteById(id)
                .then(reactiveRedisTemplate.unlink(getUserCacheKey(id)))
                .then(Mono.empty());
    }

    public Mono<Void> deleteByName(String name) {
        return userRepository.deleteByName(name);
    }

    public Mono<User> update(Long id, String name, String email) {
        return userRepository.findById(id)
                .flatMap(u -> {
                    u.setName(name);
                    u.setEmail(email);
                    return userRepository.save(u);
                })
                .flatMap(u -> reactiveRedisTemplate.unlink(getUserCacheKey(id)).then(Mono.just(u)));
    }
}
