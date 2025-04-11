package com.bright.userprofilems.dto.request;

public record UserRequestDto(
        String username,
        String password,
        ProfileRequestDto profileRequestDto
) {
}
