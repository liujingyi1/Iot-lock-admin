package com.rgk.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rgk.pojo.ReturnObject;

@SuppressWarnings("unused")
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public ReturnObject hand(Exception e) {
//    	e.printStackTrace();
//        return new ReturnObject(0, null, "unknow error!");
//    }


}
