package com.hello.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class)//Autiting 기능을 포함시킨다.
public abstract class BaseTimeEntity {
    @CreatedDate//Entity가 생성되고 저장될때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate//조회한 Entity의 값을 변경할 때 시간이 자동 저장 된다.
    private LocalDateTime modifiedDate;
}
