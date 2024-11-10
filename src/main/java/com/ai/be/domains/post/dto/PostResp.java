package com.ai.be.domains.post.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.ai.be.domains.post.entity.Post}
 */
@Builder
public record PostResp(@NotNull String id, String category, String author, String authorMessage,
                       @NotNull @Past LocalDateTime createdDate) {
    /**
     * DTO for {@link com.ai.be.domains.openAI.entity.OpenAIChat}
     */

}