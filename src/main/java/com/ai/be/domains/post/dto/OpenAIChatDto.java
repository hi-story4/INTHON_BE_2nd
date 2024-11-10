package com.ai.be.domains.post.dto;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ai.be.domains.openAI.entity.OpenAIChat}
 */
@Builder
public record OpenAIChatDto(String name, String category, String author, String shortDescription,
                            String authorMessage) implements Serializable {
}