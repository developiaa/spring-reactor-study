package pro.developia.flow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.developia.flow.dto.RegisterUserResponse;
import pro.developia.flow.service.UserQueueService;
import reactor.core.publisher.Mono;

@RequestMapping("/api/v1/queue")
@RequiredArgsConstructor
@RestController
public class UserQueueController {
    private final UserQueueService userQueueService;

    // 등록할 수 있는 API path
    @PostMapping
    public Mono<RegisterUserResponse> registerUser(
            @RequestParam(name = "queue", defaultValue = "default") String queue,
            @RequestParam(name = "user_id") Long userId) {
        return userQueueService.registerWaitQueue(queue, userId)
                .map(RegisterUserResponse::new);
    }
}
