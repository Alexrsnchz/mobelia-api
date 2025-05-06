package com.alexrsnchz.mobelia.util;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler_obsolete {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Entity doesn't exist or couldn't be found
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFound(EntityNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("timestamps", LocalDateTime.now().format(formatter));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Duplicated unique email key on user based requests
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("timestamps", LocalDateTime.now().format(formatter));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    // Duplicated unique name key on category based requests
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("timestamps", LocalDateTime.now().format(formatter));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    // Duplicated unique name key on product based requests
    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleProductAlreadyExistsException(ProductAlreadyExistsException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("timestamps", LocalDateTime.now().format(formatter));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


    // Missing body on a request that requires it
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Required request body is missing");
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("timestamps", LocalDateTime.now().format(formatter));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                ));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Field validation error");
        response.put("errors", errors);
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("timestamps", LocalDateTime.now().format(formatter));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Internal server error: " + ex.getMessage());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("timestamps", LocalDateTime.now().format(formatter));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
