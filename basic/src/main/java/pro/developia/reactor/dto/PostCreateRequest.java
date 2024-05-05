package pro.developia.reactor.dto;

import lombok.Data;

@Data
public class PostCreateRequest {
    private Long userId;
    private String title;
    private String content;

}
