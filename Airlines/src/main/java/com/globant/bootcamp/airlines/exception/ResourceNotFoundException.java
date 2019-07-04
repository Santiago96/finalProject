package com.globant.bootcamp.airlines.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String objectName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String objectName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", objectName, fieldName, fieldValue));
        this.objectName = objectName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}