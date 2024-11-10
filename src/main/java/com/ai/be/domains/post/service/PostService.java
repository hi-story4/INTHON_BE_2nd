package com.ai.be.domains.post.service;

import com.ai.be.domains.post.dto.PostDetailResp;
import com.ai.be.domains.post.dto.PostReq;
import com.ai.be.domains.post.dto.PostResp;

import java.util.List;

public interface PostService {
    void registPost(PostReq req);

    List<PostResp> getPostList(String id);

    PostDetailResp getPostDetail(String postId);

    String getPostForComment();
}
