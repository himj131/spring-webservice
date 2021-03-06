package me.star.webservice.web;

import lombok.AllArgsConstructor;
import me.star.webservice.domain.posts.PostsRepository;
import me.star.webservice.web.dto.PostsSaveRequestDto;
import me.star.webservice.web.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor //생성자 방식으로 빈을 주입(autowired 애노테이션 불필요)
public class WebRestController {

    PostsService postsService;
    PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){

        return postsService.save(dto);
    }
}
