package com.bright.userprofilems.exception;

import java.time.Instant;

public record ApiError(
        String message,
        String path,
        Integer statusCode,
        Instant timeStamp
) {
}
