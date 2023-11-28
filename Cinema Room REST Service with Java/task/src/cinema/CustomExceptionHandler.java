package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(SeatNotAvailableException.class)
    public ResponseEntity<Object> handlePurchaseException(SeatNotAvailableException exception) {
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("error", exception.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<Object> handlePurchaseException(SeatNotFoundException exception) {
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("error", exception.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }
}
