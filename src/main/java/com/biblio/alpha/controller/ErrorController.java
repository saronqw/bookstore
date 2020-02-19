package com.biblio.alpha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ErrorController {
    private final static Logger logger = LoggerFactory.getLogger(ErrorController.class);
    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception e) {
        logger.error(e.getMessage(), e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Server error");

    }
}
