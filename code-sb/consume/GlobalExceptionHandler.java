package com.example.consume;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

@Slf4j
@RestControllerAdvice
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(final Exception e) {
        ApiError apiError = new ApiError();
        apiError.setCode("500 INTERNAL_SERVER_ERROR");
        apiError.addMessage(e.getMessage());
        return ResponseEntity.internalServerError().body(apiError);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> responseStatusException(final ResponseStatusException e) {
        log.error("ResponseStatusException" + e.getLocalizedMessage());
        ApiError apiError = new ApiError();
        apiError.setCode(e.getStatusCode().toString());
        apiError.addMessage(e.getReason());
        return new ResponseEntity<>(apiError, e.getStatusCode());
    }
}
