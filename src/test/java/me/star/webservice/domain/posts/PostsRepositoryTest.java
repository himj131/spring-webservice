package me.star.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postRepository;

    @After
    public void cleanup(){
        //테스트 후 데이터 삭제
        postRepository.deleteAll();
    }

    @Test
    public void basetimeEntity_insert(){

        //given
        LocalDateTime now = LocalDateTime.now();
        postRepository.save(Posts.builder()
            .title("test")
            .content("test conts")
            .author("mj").build());

        //when
        List<Posts> postsList=postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }


    @Test
    public void selectPosts(){

        //given
        postRepository.save(Posts.builder()
        .title("test")
        .content("test")
        .author("mj")
        .build());

        //when
        List<Posts> postsList= postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo("test");
        assertThat(posts.getContent()).isEqualTo("test");


//        assertThat(posts.getTitle(), is("test"));
    }




}