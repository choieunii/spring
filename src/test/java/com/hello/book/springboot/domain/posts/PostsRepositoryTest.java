package com.hello.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After //Junit에서 단위 테스트가 끝날때마다 수행되는 메소드를 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }
    //테스트가 동시에 수행 시 테스트용 데이터 베이스인 H2에 데이터가 그대로 남아있어 다음 테스트 실행시 테스트 실패가능성 존재

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //posts 테이블에 insert/ update 쿼리를 실행
        //id가 있다면 update, 없다면 insert 쿼리를 실행한다.
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hellp@nameeer")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();
        //posts에 있는 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
