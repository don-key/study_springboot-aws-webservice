package com.donkey.book.springboot.domain.posts;

import com.donkey.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // getter 자동 생성, Entity 클래서에서는 절대 Setter 메소드를 만들지 않고, 변경이 필요 할 경우 목적과 의도를 나타낼 수 있는 메소드를 추가하여 사용한다.
@NoArgsConstructor // 기본 생성자 자동 추가 ex) public Posts(){}
@Entity // 테이블과 링크될 클래스임을 나타냄, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다 ex) SalesManager.java -> sales_manager
public class Posts extends BaseTimeEntity {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType.IDENTITY 를 추가해야만 auto_increment
    private Long id; // mysql 기준으로 bigint 타입

    @Column(length = 500, nullable = false) // @column 생략가능, 하지만 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
