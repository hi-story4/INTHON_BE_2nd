package com.ai.be.domains.user.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.ai.be.domains.user.entity.User}
 */
public record PhoneDto(@NotNull String phone) implements Serializable {
}