package com.aca.bookshelf.controller;

import com.aca.bookshelf.model.BookException;
import com.aca.bookshelf.model.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHandlerController {

    @ExceptionHandler(BookException.class)
    public ResponseEntity<ExceptionResponse> handleBookException(
            BookException bookException, HttpServletRequest request){

        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(bookException.getMessage());
        response.setRequestURI(request.getRequestURI());

        return ResponseEntity.badRequest().body(response);
    }
}
