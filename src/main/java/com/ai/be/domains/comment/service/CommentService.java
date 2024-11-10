package com.ai.be.domains.comment.service;

import com.ai.be.domains.comment.dto.CommentReq;
import com.ai.be.domains.post.dto.PostResp;

import java.util.List;

public interface CommentService {

    void registComment(CommentReq req);

}


