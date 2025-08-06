package com.green.gallery_jwt_jpa.greengram.config.exception;


import com.green.gallery_jwt_jpa.greengram.config.model.ResultResponse;
import lombok.*;
import org.springframework.validation.FieldError;

public class ValidationErrorResponse extends ResultResponse<String> {
    public ValidationErrorResponse(String message, String result) {
        super(message, result);
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ValidationError {
        private String field;
        private String message;

        public static ValidationError of(final FieldError fieldError) {
            return new ValidationError(fieldError.getField(),fieldError.getDefaultMessage());
        }

        @Override
        public String toString() {
            return String.format("field: %s, message: %s", field, message);
        }
    }
}

