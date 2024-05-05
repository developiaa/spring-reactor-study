package pro.developia.reactor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostResponse {
    private String id;
    private String content;
}
