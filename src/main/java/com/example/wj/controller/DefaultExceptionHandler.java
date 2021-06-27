package com.example.wj.controller;

import com.example.wj.result.Result;
import com.example.wj.result.ResultFactory;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleAuthorizationException(UnauthenticatedException e){
        String message = "授权认证失败";
        return ResultFactory.buildFailResult(message);
    }
}
