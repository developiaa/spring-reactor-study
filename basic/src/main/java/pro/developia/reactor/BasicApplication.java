package pro.developia.reactor;

import lombok.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class BasicApplication implements ApplicationRunner {
//    private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
//    private final UserRepository userRepository;
//
    public static void main(String[] args) {
//        BlockHound.install();
        SpringApplication.run(BasicApplication.class, args);
    }
//
//    @GetMapping("/health")
//    public Mono<Map<String, String>> health() {
//        return Mono.just(Map.of("health", "ok"));
//    }
//
//    @GetMapping("/user/1/cache")
//    public Mono<Map<String, String>> getCachedUser() {
//        var name = reactiveRedisTemplate.opsForValue().get("users:1:name");
//        var email = reactiveRedisTemplate.opsForValue().get("users:1:email");
//
//        return Mono.zip(name, email)
//                .map(i -> Map.of("name", i.getT1(), "email", i.getT2()));
//    }
//
//    @GetMapping("/user/{id}")
//    public Mono<User> getUser(@PathVariable Long id) {
//        return userRepository.findById(id).defaultIfEmpty(new User());
//    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Mono.delay(Duration.ofSeconds(1))
//                .doOnNext(it -> {
//                    try {
//                        Thread.sleep(1000); // blocking
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//                .subscribe();
    }
}

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Table("users")
//class User {
//    @Id
//    private Long id;
//    private String name;
//    private String email;
//    @CreatedDate
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
//}
//
//interface UserRepository extends ReactiveCrudRepository<User, Long> {
//}
