package poc.vivek.gateway.exception;

import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import poc.vivek.common.model.ResponseEntityBuilder;
import poc.vivek.common.model.ResponseModel;

@RestControllerAdvice
public class GenericExceptionHandler {
    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<?> malformedJwtException(MalformedJwtException malformedJwtException) {
        malformedJwtException.printStackTrace();
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.UNAUTHORIZED).setErCode("998").setMessage("FAILURE").setBody("Invalid request").build();
    }
}
