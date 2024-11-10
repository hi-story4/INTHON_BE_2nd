package com.ai.be.domains.openAI.mapper;

import com.ai.be.domains.openAI.dto.OpenAiChatResp;
import com.ai.be.domains.openAI.entity.OpenAIChat;
import com.ai.be.domains.post.dto.OpenAIChatDto;
import com.ai.be.domains.post.dto.PostResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    OpenAIChat toEntity(OpenAiChatResp chatDto);
    OpenAiChatResp toDto(OpenAIChat chatEntity);

    OpenAIChatDto toDetailDto(OpenAIChat openAIChat);

}
