package pro.developia.reactor.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import pro.developia.reactor.dto.UserCreateRequest;
import pro.developia.reactor.dto.UserResponse;
import pro.developia.reactor.dto.UserUpdateRequest;
import pro.developia.reactor.repository.User;
import pro.developia.reactor.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest(UserController.class)
@AutoConfigureWebTestClient
class UserControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserService userService;

    @Test
    void createUser() {
        when(userService.create("developia", "developiaa@gmail.com"))
                .thenReturn(
                        Mono.just(
                                new User(1L, "developia", "developiaa@gmail.com",
                                        LocalDateTime.now(), LocalDateTime.now())
                        )
                );

        webTestClient.post().uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new UserCreateRequest("developia", "developiaa@gmail.com"))
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(UserResponse.class)
                .value(res -> {
                    assertEquals("developia", res.getName());
                    assertEquals("developiaa@gmail.com", res.getEmail());
                });
    }

    @Test
    void findAllUsers() {
        when(userService.findAll()).thenReturn(
                Flux.just(
                        new User(1L, "developia", "developiaa@gmail.com",
                                LocalDateTime.now(), LocalDateTime.now()),
                        new User(2L, "developia", "developiaa@gmail.com",
                                LocalDateTime.now(), LocalDateTime.now()),
                        new User(3L, "developia", "developiaa@gmail.com",
                                LocalDateTime.now(), LocalDateTime.now())
                )
        );

        webTestClient.get().uri("/users")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(UserResponse.class)
                .hasSize(3);
    }

    @Test
    void findUser() {
        when(userService.findById(1L)).thenReturn(
                Mono.just(new User(1L, "developia", "developiaa@gmail.com",
                        LocalDateTime.now(), LocalDateTime.now()))
        );

        webTestClient.get().uri("/users/1")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(UserResponse.class)
                .value(res -> {
                    assertEquals("developia", res.getName());
                    assertEquals("developiaa@gmail.com", res.getEmail());
                });
    }

    @Test
    void noFoundUser() {
        when(userService.findById(1L)).thenReturn(
                Mono.empty()
        );

        webTestClient.get().uri("/users/1")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void deleteUser() {
        when(userService.deleteById(1L)).thenReturn(
                Mono.empty()
        );

        webTestClient.delete().uri("/users/1")
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

    @Test
    void updateUser() {
        when(userService.update(1L, "developia", "developiaa@gmail.com"))
                .thenReturn(
                        Mono.just(
                                new User(1L, "developia", "developiaa@gmail.com",
                                        LocalDateTime.now(), LocalDateTime.now())
                        )
                );

        webTestClient.put().uri("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new UserUpdateRequest("developia", "developiaa@gmail.com"))
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(UserResponse.class)
                .value(res -> {
                    assertEquals("developia", res.getName());
                    assertEquals("developiaa@gmail.com", res.getEmail());
                });
    }
}
