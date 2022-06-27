package com.example.lab3.aspect;

import com.example.lab3.exception.AOPIsAwesomeHeaderException;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Aspect

public class AopIsAwesomeHeaderAspect {
    private final HttpServletRequest httpServletRequest;

    @Pointcut("within(com.example.lab3.service..*)")
    public void headerChecker() {
    }

    @Before("headerChecker()")
    public void execute(JoinPoint joinPoint) throws Throwable {
        if (httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME") == null) {
            throw new AOPIsAwesomeHeaderException("Header required");
        }
    }

}
