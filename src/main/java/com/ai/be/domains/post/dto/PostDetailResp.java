package com.ai.be.domains.post.dto;

import com.ai.be.domains.comment.dto.CommentResp;
import jakarta.validation.constraints.Past;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.ai.be.domains.post.entity.Post}
 */

@Builder
public record PostDetailResp(String id, String content, OpenAIChatDto chat, List<CommentResp> comments,
                             @Past LocalDateTime createdDate) {
}