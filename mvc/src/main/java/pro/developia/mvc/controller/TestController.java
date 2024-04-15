package pro.developia.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/posts/{id}")
    public Map<String, String> getPosts(@PathVariable("id") Long id) throws Exception {
        Thread.sleep(300);
        if (id > 10L) {
            throw new Exception("Too Long");
        }
        return Map.of("id", id.toString(), "content", "Posts content is %d".formatted(id));
    }
}
