package com.hello.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // GET 메소드를 생성
@RequiredArgsConstructor //final field가 포함된 생성자를 생성해준다.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
