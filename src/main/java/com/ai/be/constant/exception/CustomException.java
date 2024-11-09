package com.ai.be.constant.exception;

import com.ai.be.constant.response.CustomResponseStatus;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final CustomResponseStatus customResponseStatus;


    public CustomException(CustomResponseStatus customResponseStatus) {

        super(customResponseStatus.getMessage());
        this.customResponseStatus = customResponseStatus;
    }
}


