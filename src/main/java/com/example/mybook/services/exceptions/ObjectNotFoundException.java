package com.example.mybook.services.exceptions;

//pacote de exceptions
public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    //apenas a mensagem
    public ObjectNotFoundException(String message) {
        super(message);
    }

    // causa e mensagem
    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
