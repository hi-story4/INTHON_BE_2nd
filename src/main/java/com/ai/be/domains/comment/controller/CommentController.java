package com.ai.be.domains.comment.controller;

import com.ai.be.constant.response.ApiResponse;
import com.ai.be.domains.comment.dto.CommentReq;
import com.ai.be.domains.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;

  @PostMapping
  public ResponseEntity<ApiResponse<String>> registComment(
    @ModelAttribute CommentReq req
  ) {
    commentService.registComment(req);
    return ApiResponse.createSuccessWithOk("success");
  }
}
