package com.ai.be.domains.comment.entity;

import com.ai.be.constant.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Index;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Document
public class Comment extends BaseEntity {
    @Id
    String id;

    @Indexed
    String userId;
    @Indexed
    String postId;

    String commentContent;

}