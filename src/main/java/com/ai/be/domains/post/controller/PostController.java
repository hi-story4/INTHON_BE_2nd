package com.ai.be.domains.post.controller;

import com.ai.be.constant.response.ApiResponse;
import com.ai.be.domains.post.dto.PostDetailResp;
import com.ai.be.domains.post.dto.PostReq;
import com.ai.be.domains.post.dto.PostResp;
import com.ai.be.domains.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;


    //Post 리스트 : 내 보관함
    //Get
    @PostMapping("/{id}")
    public ResponseEntity<ApiResponse<List<PostResp>>> getPostList(@PathVariable("id") String id) {

        List<PostResp> responses = postService.getPostList(id);
        return ApiResponse.createSuccessWithOk(responses);
    }

    //Get
    @PostMapping("/detail/{postId}")
    public ResponseEntity<ApiResponse<PostDetailResp>> getPostDetail(@PathVariable("postId") String postId){

        PostDetailResp response = postService.getPostDetail(postId);
        return ApiResponse.createSuccessWithOk(response);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<String>> registPost(@ModelAttribute PostReq req) {

        postService.registPost(req);

        return ApiResponse.createSuccessWithOk("Success");

    }

    //Get
    @PostMapping("/similar")
    public ResponseEntity<ApiResponse<String>> getOtherPostForComment(){

        String response = postService.getPostForComment();
        return ApiResponse.createSuccessWithOk(response);
    }


}


