package com.hello.book.springboot.web;

import com.hello.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
public class HelloController {
    @GetMapping("/hello") // GET 요청을 받을 수 있는 API를 만들어준다.
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name,
                                             @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
