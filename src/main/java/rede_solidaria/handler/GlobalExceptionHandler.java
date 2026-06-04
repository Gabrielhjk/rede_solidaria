package rede_solidaria.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// tratamento de erros globais
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    // pega o erro de regra de negocio
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> globlaExceptionHandler(BusinessException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // pega o erro de validacoes dos campos
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<ErrorResponse> fieldNullHandler(MethodArgumentNotValidException exception) {
        String errorMessage = exception.getBindingResult()
                                       .getFieldErrors()
                                       .get(0)
                                       .getDefaultMessage();

        return new ResponseEntity<>(new ErrorResponse(errorMessage), HttpStatus.BAD_REQUEST);    
    }
}
