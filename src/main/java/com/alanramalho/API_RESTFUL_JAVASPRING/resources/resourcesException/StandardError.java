package com.alanramalho.API_RESTFUL_JAVASPRING.resources.resourcesException;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Long timesTamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {

    }

    public StandardError(Long timesTamp, Integer status, String error, String message, String path) {
        this.timesTamp = timesTamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(Long timesTamp) {
        this.timesTamp = timesTamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
