package com.hello.book.springboot.domain.posts;

import lombok.Builder;
//해당 클래스의 빌더 패턴 클래스를 생성, 생성자에 포함된 필드만 빌더에 포함
import lombok.Getter;
//클래스 내 모든 필드의 Getter 메소드를 자동 생성
import lombok.NoArgsConstructor;
//기본 생성자 자동 추가
import javax.persistence.*;
@Getter
@NoArgsConstructor // 롬복의 어노테이션
@Entity // JPA의 어노테이션
//테이블과 링크될 클래스 임을 나타낸다. 절대 Setter 메소드를 만들지 않는다.
public class Posts {
    @Id //PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK 생성 규칙을 나타낸다. Gene... -> 옵션을 스프링부트 2.0에서 추가해야만 auto_increment 가 된다.
    //PK를 자동으로 increment 하는것
    private Long id;

    @Column(length = 500, nullable = false)
    //테이블의 칼럼을 나타낸다. 기본 값 왜ㅣ에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    //문자열의 경우 varchar(255)가 기본, 타입변경, 문자열 길이 변경 등시 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public void update(String title, String content){
        this.title = title;
        this.content=content;
    }
}
