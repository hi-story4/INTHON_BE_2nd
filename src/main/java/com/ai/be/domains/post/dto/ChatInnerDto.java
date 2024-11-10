package com.ai.be.domains.post.dto;

import lombok.Builder;

@Builder
public record ChatInnerDto(String category, String author, String authorMessage) {
}