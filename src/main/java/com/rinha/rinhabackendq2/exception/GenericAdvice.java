package com.rinha.rinhabackendq2.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GenericAdvice {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Map<String, Object>> handleNotFound(HttpServletRequest request, Exception e) {
        return ExceptionResponse.from(e).setPath(request).setStatus(HttpStatus.NOT_FOUND).build();

    }
}
