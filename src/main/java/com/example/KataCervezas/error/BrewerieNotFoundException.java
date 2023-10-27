package com.example.KataCervezas.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BrewerieNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 43876691117560211L;
    public BrewerieNotFoundException(Integer id) {
        super("Cervecería con ID "+id+" no encontrada");
    }
}
