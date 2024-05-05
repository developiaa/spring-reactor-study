package pro.developia.reactor.dto;

import lombok.Builder;
import lombok.Data;
import pro.developia.reactor.repository.Post;

import java.time.LocalDateTime;

@Builder
@Data
public class UserPostResponse {
    private Long id;
    private String username;
    private String content;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserPostResponse of(Post post) {
        return UserPostResponse.builder()
                .id(post.getId())
                .username(post.getUser().getName())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
