package com.hello.book.springboot.web;

import com.hello.book.springboot.service.posts.PostsService;
import com.hello.book.springboot.web.dto.PostsResponseDto;
import com.hello.book.springboot.web.dto.PostsSaveRequestDto;
import com.hello.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    //Autowired 없는 이유는 생성자로 의존성 주입을 받기 때문(@RequiredArgsContructor)
    //롬복을 사용하게 되면 해당 클래스의 의존성 관계가 변경되어도 코드 변경이 필요없기 때문이다.
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody
            PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
