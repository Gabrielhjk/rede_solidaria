package rede_solidaria.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GloblaExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse globlaExceptionHandler(BusinessException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
