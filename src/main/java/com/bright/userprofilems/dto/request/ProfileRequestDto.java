package com.bright.userprofilems.dto.request;

import java.time.LocalDate;

public record ProfileRequestDto(
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String email,
        String phoneNumber,
        String bio
) {
}