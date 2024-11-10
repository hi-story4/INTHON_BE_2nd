package com.ai.be.domains.comment.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link com.ai.be.domains.comment.entity.Comment}
 */
public record CommentReq(
  @NotNull @Pattern(regexp = "^[0-9]{10,11}$", message = "휴대폰 번호는 10-11자리의 숫자만 입력 가능합니다" ) String phone,
  @NotNull String postId,


  @Size(min = 10, max = 500) @NotEmpty String commentContent
)
{}
