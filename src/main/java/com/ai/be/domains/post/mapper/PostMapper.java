package com.ai.be.domains.post.mapper;


import com.ai.be.domains.openAI.entity.OpenAIChat;
import com.ai.be.domains.openAI.mapper.ChatMapper;
import com.ai.be.domains.openAI.dto.OpenAiChatResp;
import com.ai.be.domains.post.dto.ChatInnerDto;
import com.ai.be.domains.post.dto.PostDetailResp;
import com.ai.be.domains.post.dto.PostResp;
import com.ai.be.domains.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = ChatMapper.class)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post toEntity(String content, String nickname, String twinPostId, String userId, OpenAiChatResp chat);




}
