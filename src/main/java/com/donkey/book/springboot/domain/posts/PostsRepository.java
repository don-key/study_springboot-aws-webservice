package com.donkey.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// ibatis나 MyBatis 등에서 Dao(Data Access Object)라고 불리는 DB Layer 접근자, JPA에선 Repository라고 부른다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
