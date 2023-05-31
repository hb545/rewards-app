package com.exam.rewards.exceptions;

import com.exam.rewards.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> noDataFoundException(NotFoundException ex,  WebRequest request){
        Response response = new Response();
        response.setMessage(ex.getText());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
