package com.alanramalho.API_RESTFUL_JAVASPRING.services.ServicesExceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
