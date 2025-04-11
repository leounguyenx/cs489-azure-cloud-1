package com.bright.userprofilems.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProfileRequestDto(
        @NotBlank(message = "firstName cannot be blank/empty/null")
        String firstName,
        @NotBlank(message = "lastName cannot be blank/empty/null")
        String lastName,
        @NotNull(message = "dob cannot be null")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate dateOfBirth,
        @NotBlank(message = "email cannot be blank/empty/null")
        @Email(message = "invalid email format")
        String email,
        @NotBlank(message = "phoneNumber cannot be blank/empty/null")
        String phoneNumber,
        @NotBlank(message = "bio cannot be blank/empty/null")
        String bio
) {
}