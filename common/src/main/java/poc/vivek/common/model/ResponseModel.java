package poc.vivek.common.model;

public class ResponseModel {
    private String status;
    private String code;
    private Object body;

    public ResponseModel(String status, String code, Object body) {
        this.status = status;
        this.code = code;
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }


}
