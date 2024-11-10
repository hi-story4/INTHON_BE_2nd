package com.ai.be.domains.openAI.service;


import com.ai.be.config.OpenAIConfig;
import com.ai.be.constant.exception.CustomException;
import com.ai.be.constant.response.CustomResponseStatus;
import com.ai.be.domains.openAI.dto.OpenAiChatResp;
import com.ai.be.domains.openAI.utils.OpenAIUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.document.MetadataMode;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.openai.OpenAiEmbeddingModel;
import org.springframework.ai.openai.OpenAiEmbeddingOptions;
import org.springframework.ai.retry.RetryUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenAIServiceImpl implements OpenAIService {

    private final OpenAIUtil openAIUtil;
    private final OpenAIConfig openAIConfig;
    private final ChatModel chatModel;
    private final EmbeddingModel embeddingModel;

    @Transactional
    public OpenAiChatResp getOpenAIChat(String postContent) {
        BeanOutputConverter<OpenAiChatResp> converter = new BeanOutputConverter<>(OpenAiChatResp.class);

        try {
            Prompt prompt = openAIUtil.openAiChatPrompt(postContent);
            ChatResponse chatResponse = chatModel.call(prompt);
            OpenAiChatResp response = converter.convert(chatResponse.getResult().getOutput().getContent());
            return response;
        }
        catch (Exception e){
            throw new CustomException(CustomResponseStatus.AI_RESPONSE_ERROR);
        }
    }

    @Transactional
    public void getEmbedding(String postContent){

//        EmbeddingModel model = openAIConfig.getEmbeddingModel();
        EmbeddingResponse embeddingResponse = this.embeddingModel.embedForResponse(List.of(postContent));

        log.info(Map.of("임베딩 :", embeddingResponse.getResult()).toString());

    }


}
