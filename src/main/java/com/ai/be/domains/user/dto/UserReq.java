package com.ai.be.domains.user.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.ai.be.domains.user.entity.User}
 */
public record UserReq(@NotNull @Pattern(regexp = "^[0-9]{10,11}$", message = "휴대폰 번호는 10-11자리의 숫자만 입력 가능합니다")
                      String phone,
                      @NotNull @Size(min = 4, max = 15) String password) {
}