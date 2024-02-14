package poc.vivek.common.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder<T> {
    private HttpStatusCode statusCode;
    private String message;
    private String erCode;
    private Object body;

    public ResponseEntityBuilder<T> setStatusCode(HttpStatusCode httpStatusCode) {
        this.statusCode = httpStatusCode;
        return this;
    }

    public ResponseEntityBuilder<T> setErCode(String erCode) {
        this.erCode = erCode;
        return this;
    }

    public ResponseEntityBuilder<T> setBody(Object body) {
        this.body = body;
        return this;
    }

    public ResponseEntityBuilder<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseEntity<T> build(HttpHeaders headers) {
        ResponseModel responseModel = new ResponseModel(message, erCode, body);
        return new ResponseEntity<>((T) responseModel, headers, statusCode);
    }

    public ResponseEntity<T> build() {
        ResponseModel responseModel = new ResponseModel(message, erCode, body);
        return new ResponseEntity<>((T) responseModel, statusCode);
    }

}
