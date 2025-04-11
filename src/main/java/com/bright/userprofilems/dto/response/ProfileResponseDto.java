package com.bright.userprofilems.dto.response;

import java.time.LocalDate;

public record ProfileResponseDto(
        String firstName,
        String lastName,
//        LocalDate dateOfBirth,
//        String email,
//        String phoneNumber,
        String bio
) {
}
