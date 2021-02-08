package com.hello.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Posts와 PostsRepository는 항상 함께 해야하기에 domain 패키지에서 함께 관리한다.
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
