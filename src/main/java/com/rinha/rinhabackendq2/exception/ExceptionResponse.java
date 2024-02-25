package com.rinha.rinhabackendq2.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

public class ExceptionResponse<T extends Exception> {
    private final HashMap<String, Object> attributes = new HashMap<>();
    private HttpStatus status;

    private ExceptionResponse(T ex) {
        this.attributes.put("timestamp", LocalDateTime.now().atOffset(ZoneOffset.UTC));
        this.attributes.put("error_class", ex.getClass().getSimpleName());
        this.attributes.put("message", ex.getMessage());
    }

    public static <T extends Exception> ExceptionResponse<T> from(T ex) {
        return new ExceptionResponse<>(ex);
    }

    public ExceptionResponse<T> setPath(HttpServletRequest path) {
        this.attributes.put("path", path.getServletPath());
        return this;
    }

    public ExceptionResponse<T> setPath(String path) {
        this.attributes.put("path", path);
        return this;
    }

    public ExceptionResponse<T> setMessage(String message) {
        this.attributes.put("message", message);
        return this;
    }

    public ExceptionResponse<T> setStatus(HttpStatus status) {
        this.status = status;
        this.attributes.put("status", status.value());
        this.attributes.put("error", status.getReasonPhrase());
        return this;
    }

    public ResponseEntity<Map<String, Object>> build() {
        return ResponseEntity.status(this.status).body(this.attributes);
    }
}