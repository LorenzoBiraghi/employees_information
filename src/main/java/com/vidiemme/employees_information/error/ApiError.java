package com.vidiemme.employees_information.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class ApiError {

    @Getter
    @Setter
    private HttpStatus httpStatus;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private HashMap<String, Object> errors;

    /**
     * Constructor
     * @param httpStatus
     * @param message
     * @param errors
     */
    public ApiError(HttpStatus httpStatus, String message, HashMap<String, Object> errors) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }

    /**
     * Constructor with one error
     * @param httpStatus
     * @param message
     * @param error
     */
    public ApiError(HttpStatus httpStatus, String message, String error){
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        HashMap<String, Object> errors = new HashMap<String, Object>();
        errors.put("GENERIC", error);
        this.errors = errors;
    }
}
