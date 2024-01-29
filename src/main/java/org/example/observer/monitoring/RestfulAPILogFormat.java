package org.example.observer.monitoring;

public class RestfulAPILogFormat {
    private int status;
    private String message;

    public RestfulAPILogFormat(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
