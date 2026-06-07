package com.personalinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    int statusCode;
    String message;

    public ErrorResponse(String message){
        super();
        this.message= message;
    }

}
