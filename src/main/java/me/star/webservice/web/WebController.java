package me.star.webservice.web;

import lombok.AllArgsConstructor;
import me.star.webservice.domain.posts.PostsRepository;
import me.star.webservice.web.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
public class WebController {

   @GetMapping("/")
    public String main(){
       return "main";
   }
}
