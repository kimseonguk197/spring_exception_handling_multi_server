package com.example.board.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    //    404에러
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(EntityNotFoundException e) {
        final ErrorResponse response = new ErrorResponse
                (LocalDateTime.now(),HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //    400에러
    @ExceptionHandler(NoListException.class)
    protected ResponseEntity<ErrorResponse> handleNoListException(NoListException e) {
        final ErrorResponse response = new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}