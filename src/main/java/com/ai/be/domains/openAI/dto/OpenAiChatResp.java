package com.ai.be.domains.openAI.dto;

public record OpenAiChatResp(
        String name,
        String category,
        String author,
        String shortDescription,
        String authorMessage
) {
}
