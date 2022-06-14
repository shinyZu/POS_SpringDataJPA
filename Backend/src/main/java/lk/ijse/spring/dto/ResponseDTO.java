package lk.ijse.spring.dto;

public class ResponseDTO {
    private int status;
    private String message;
    private Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(int status, String message, Object data) {
        this.setStatus(status);
        this.setMessage(message);
        this.setData(data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
