package com.bright.userprofilems.dto.response;

public record UserResponseDto(
        String username,
        ProfileResponseDto profileResponseDto
) {
}
