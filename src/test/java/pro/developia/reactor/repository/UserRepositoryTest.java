package pro.developia.reactor.repository;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Test
    void save() {
        User user = User.builder()
                .name("developia")
                .email("developiaa@gmail.com")
                .build();
        StepVerifier.create(userRepository.save(user))
                .assertNext(u -> {
                    assertEquals(1L, u.getId());
                    assertEquals("developia", u.getName());
                    assertEquals("developiaa@gmail.com", u.getEmail());
                })
                .verifyComplete();
    }

    @Test
    void findAll() {
        userRepository.save(User.builder()
                .name("developia1")
                .email("developiaa1@gmail.com")
                .build());

        userRepository.save(User.builder()
                .name("developia2")
                .email("developiaa2@gmail.com")
                .build());

        userRepository.save(User.builder()
                .name("developia3")
                .email("developiaa3@gmail.com")
                .build());

        StepVerifier.create(userRepository.findAll())
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void findById() {
        userRepository.save(User.builder()
                .name("developia1")
                .email("developiaa1@gmail.com")
                .build());

        userRepository.save(User.builder()
                .name("developia2")
                .email("developiaa2@gmail.com")
                .build());

        StepVerifier.create(userRepository.findById(2L))
                .assertNext(u -> {
                    assertEquals(2L, u.getId());
                    assertEquals("developia2", u.getName());
                    assertEquals("developiaa2@gmail.com", u.getEmail());
                })
                .verifyComplete();
    }

    @Test
    void deleteById() {
        userRepository.save(User.builder()
                .name("developia1")
                .email("developiaa1@gmail.com")
                .build());

        userRepository.save(User.builder()
                .name("developia2")
                .email("developiaa2@gmail.com")
                .build());

        StepVerifier.create(userRepository.deleteById(1L))
                .expectNextCount(1)
                .verifyComplete();
    }
}
