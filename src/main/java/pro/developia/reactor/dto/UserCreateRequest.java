package pro.developia.reactor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserCreateRequest {
    private String name;
    private String email;
}
