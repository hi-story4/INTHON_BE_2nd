package com.ai.be.domains.post.repository;

import com.ai.be.domains.post.entity.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {


    List<Post> findByUserIdOrderByCreatedDateDesc(String userId);

    Optional<Post> findFirstByCommentIdsEmptyOrderByCreatedDateAsc();
}
