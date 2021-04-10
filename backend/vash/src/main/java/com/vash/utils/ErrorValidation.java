package com.vash.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class ErrorValidation {

    public static ResponseEntity<Map<String, String>> getValidationErrorMap(BindingResult result) {
        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();
            for(FieldError field : result.getFieldErrors()) {
                errorMap.put(field.getField(), field.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }
        return null;
    }
}
