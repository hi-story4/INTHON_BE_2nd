package com.ai.be.domains.comment.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.ai.be.domains.comment.entity.Comment}
 */
public record CommentResp(String id, String commentContent) implements Serializable {
}