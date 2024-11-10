package com.ai.be.domains.sms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.ai.be.domains.user.entity.User}
 */

@Builder
public record SmsReq(@NotNull String phone, @NotNull String message)  {
}