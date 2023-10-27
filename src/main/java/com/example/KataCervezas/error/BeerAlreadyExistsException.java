package com.example.KataCervezas.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BeerAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 43876691117560211L;
    public BeerAlreadyExistsException(Integer id) {
        super("Cerveza con ID "+id+" ya existe");
    }
}
