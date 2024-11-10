package com.ai.be.domains.comment.service;

import com.ai.be.constant.exception.CustomException;
import com.ai.be.constant.response.CustomResponseStatus;
import com.ai.be.domains.comment.dto.CommentReq;
import com.ai.be.domains.comment.entity.Comment;
import com.ai.be.domains.comment.mapper.CommentMapper;
import com.ai.be.domains.comment.repository.CommentRepository;
import com.ai.be.domains.post.entity.Post;
import com.ai.be.domains.post.repository.PostRepository;
import com.ai.be.domains.user.entity.User;
import com.ai.be.domains.user.repository.UserRepository;
import com.ai.be.domains.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserService userService;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Transactional
    public void registComment(CommentReq req) {

        // post id 기반
        String postId = req.postId();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(CustomResponseStatus.POST_NOT_FOUND));
        User user = userRepository.findByPhone(req.phone()).orElseThrow(()-> new CustomException(CustomResponseStatus.MEMBER_NOT_FOUND))
;        //Comment 저장.
        Comment comment = commentMapper.toEntity(req, user.getId());

        try {
            Comment responseComment = commentRepository.save(comment);
            // Post에 Comment Id 값 추가
            String commentId = responseComment.getId();
            post.getCommentIds().add(commentId);
            postRepository.save(post);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CustomException(CustomResponseStatus.COMMENT_SAVED_ERROR);
        }


        // Post를 작성한 유저의 전화번호로 Comment 답장 알림을 보냄.
        String postUserId = post.getUserId();
        userService.sendCommentMessageByUserId(postUserId);

    }


}
