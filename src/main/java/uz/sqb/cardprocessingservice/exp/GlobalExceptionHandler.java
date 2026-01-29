package uz.sqb.cardprocessingservice.exp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String,Object>> handleException(UserAlreadyExistsException e) {
        Map<String,Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", 409);
        error.put("error","Conflict");
        error.put("message", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
