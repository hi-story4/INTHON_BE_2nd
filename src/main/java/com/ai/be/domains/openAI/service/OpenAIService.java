package com.ai.be.domains.openAI.service;

import com.ai.be.domains.openAI.dto.OpenAiChatResp;

public interface OpenAIService {

    OpenAiChatResp getOpenAIChat(String postContent);

    void getEmbedding(String postContent);
}

