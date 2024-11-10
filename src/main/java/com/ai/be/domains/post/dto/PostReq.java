package com.ai.be.domains.post.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

/**
 * DTO for {@link com.ai.be.domains.post.entity.Post}
 */

@Builder
public record PostReq(@NotNull @Size(max = 500, message = "텍스트 길이 최대 500자") String content,
                      @NotNull String nickname,
                      String twinPostId,

                      @NotNull @Pattern(regexp = "^[0-9]{10,11}$", message = "휴대폰 번호는 10-11자리의 숫자만 입력 가능합니다")
                      String phone) {
}