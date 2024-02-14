package poc.vivek.user.exception;

import jakarta.validation.UnexpectedTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import poc.vivek.common.model.ResponseEntityBuilder;
import poc.vivek.common.model.ResponseModel;


@RestControllerAdvice
public class GenericExceptionHandler {
    private static final Logger logger = LogManager.getLogger(GenericExceptionHandler.class);

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<ResponseModel> unexpectedTypeException(Exception ex) {
       ex.printStackTrace();
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.BAD_REQUEST).setErCode("998").setMessage("FAILURE").setBody(ex.getMessage()).build();
    }

    @ExceptionHandler(DbActionExecutionException.class)
    public ResponseEntity<ResponseModel> dbActionExecutionException(DbActionExecutionException ex) {
        ex.printStackTrace();
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR).setErCode("999").setMessage("FAILURE").setBody("Something went wrong !!!").build();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel> exception(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR).setErCode("999").setMessage("FAILURE").setBody(ex.getMessage()).build();
    }

}
