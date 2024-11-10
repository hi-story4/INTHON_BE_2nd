package com.ai.be.domains.comment.repository;


import com.ai.be.domains.comment.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {


    List<Comment> findByPostId(String postId);
}
