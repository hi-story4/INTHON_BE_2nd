package com.ai.be.domains.post.entity;

import com.ai.be.constant.entity.BaseEntity;
import com.ai.be.domains.openAI.entity.OpenAIChat;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document
@Table(name = "post")
public class Post extends BaseEntity {
    @Id
    String id;

    @Indexed
    String userId;

    String nickname;

    String content;

    String twinPostId;

    @Builder.Default
    List<String> commentIds = new ArrayList<>();

    OpenAIChat chat;

//    public void increaseCommentCount() {
//        this.commentCount = this.commentCount + 1;
//    }
}