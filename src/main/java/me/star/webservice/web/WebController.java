package me.star.webservice.web;

import lombok.AllArgsConstructor;
import me.star.webservice.domain.posts.PostsRepository;
import me.star.webservice.web.dto.PostsSaveRequestDto;
import me.star.webservice.web.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model){
       model.addAttribute("posts", postsService.findAllDesc());
       return "main";
   }
}
