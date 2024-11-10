package com.ai.be.domains.comment.mapper;

import com.ai.be.domains.comment.dto.CommentReq;
import com.ai.be.domains.comment.dto.CommentResp;
import com.ai.be.domains.comment.entity.Comment;
import com.ai.be.domains.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);
    Comment toEntity(CommentReq req, String userId);

    List<CommentResp> toDtoList(List<Comment> comments);

}
