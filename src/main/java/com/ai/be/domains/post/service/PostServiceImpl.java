package com.ai.be.domains.post.service;

import com.ai.be.constant.exception.CustomException;
import com.ai.be.constant.response.CustomResponseStatus;
import com.ai.be.domains.comment.dto.CommentResp;
import com.ai.be.domains.comment.entity.Comment;
import com.ai.be.domains.comment.mapper.CommentMapper;
import com.ai.be.domains.comment.repository.CommentRepository;
import com.ai.be.domains.openAI.dto.OpenAiChatResp;
import com.ai.be.domains.openAI.mapper.ChatMapper;
import com.ai.be.domains.openAI.service.OpenAIService;
import com.ai.be.domains.post.dto.PostDetailResp;
import com.ai.be.domains.post.dto.PostReq;
import com.ai.be.domains.post.dto.PostResp;
import com.ai.be.domains.post.entity.Post;
import com.ai.be.domains.post.mapper.PostMapper;
import com.ai.be.domains.post.repository.PostRepository;
import com.ai.be.domains.user.entity.User;
import com.ai.be.domains.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;


@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    private final CommentRepository commentRepository;

    private final ChatMapper chatMapper;
    private final CommentMapper commentMapper;
    //    private final PostRepository postRepository;
    private final UserService userService;
    private final OpenAIService openAIService;
    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Transactional(readOnly = true)
    public PostDetailResp getPostDetail(String postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(CustomResponseStatus.POST_NOT_FOUND));

        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentResp> commentDtoList = commentMapper.toDtoList(comments);

        return PostDetailResp
                .builder()
                .id(post.getId())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .comments(commentDtoList)
                .chat(chatMapper.toDetailDto(post.getChat()))
                .build();
    }

    @Transactional(readOnly = true)
    public List<PostResp> getPostList(String id) {
        try {
            User user = userService.getUserById(id);

            List<Post> posts = postRepository.findByUserIdOrderByCreatedDateDesc(user.getId());

            return posts.stream()
                    .map(post -> PostResp.builder()
                            .id(post.getId())
                            .author(post.getChat().getAuthor())
                            .authorMessage(post.getChat().getAuthorMessage())
                            .category(post.getChat().getCategory())
                            .createdDate(post.getCreatedDate())
                            .build()).collect(Collectors.toList());

        } catch (Exception e) {
            throw new CustomException(CustomResponseStatus.POST_NOT_FOUND);
        }
    }

    @Transactional
    public void registPost(PostReq req) {
        // Embedding 벡터값 가져오기

        // Post와 User 매핑, user phone 없으면 회원가입 - 있으면 그냥 저장.
        Optional<User> optionalUser = userService.getUserByPhone(req.phone());


        //초기 방문인 경우 자동 회원가입

        String userId = optionalUser.isEmpty()
                ? userService.registUserByPhone(req.phone()).getId()
                : optionalUser.get().getId();

        //Chat 값 저장
        OpenAiChatResp aiChatResponse = openAIService.getOpenAIChat(req.content());

        Post post = postMapper.toEntity(req.content(), req.nickname(),req.twinPostId(), userId, aiChatResponse);

        //**
        // 벡터값과 함께 각 저장


        try {
            postRepository.save(post);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            throw new CustomException(CustomResponseStatus.POST_SAVED_ERROR);
        }

    }

    @Transactional(readOnly = true)
    public String getPostForComment() {
        String format ="672feadbd2c04255c289416c";
//        Post post = postRepository.findFirstByCommentIdsEmptyOrderByCreatedDateAsc()
//                .orElseThrow(() -> new CustomException(CustomResponseStatus.POST_NOT_FOUND));
        //
        //
        //
        //
        //
        //

        Post post = postRepository.findById(format)
                .orElseThrow(() -> new CustomException(CustomResponseStatus.POST_NOT_FOUND));
        return post.getId();
    }

//        List<Comment> comments = commentRepository.findByPostId(post.getId());
//
//        return PostDetailResp.builder()
//                .id(post.getId())
//                .content(post.getContent())
//                .chat(chatMapper.toDetailDto(post.getChat()))
//                .comments(comments.stream().map(comment -> CommentResp.builder()
//                        .id(comment.getId())
//                        .commentContent(comment.getCommentContent())
//                        .build()).collect(Collectors.toList()))
//                .createdDate(post.getCreatedDate())
//                .build();
//    }
}
