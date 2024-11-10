package com.ai.be.domains.comment.dto;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ai.be.domains.comment.entity.Comment}
 */

@Builder
public record CommentResp(String id, String commentContent) implements Serializable {
}