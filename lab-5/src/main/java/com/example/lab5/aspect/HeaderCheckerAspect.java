package com.example.lab5.aspect;

import com.example.lab5.exception.AOPIsAwesomeHeaderException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class HeaderCheckerAspect {

    private final HttpServletRequest httpServletRequest;
    @Pointcut("within(com.example.lab5.service..*)")
    public void headerChecker() {
    }

    @Before("headerChecker()")
    public void execute(JoinPoint joinPoint) throws Throwable{
        if (httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME") == null){
            throw new AOPIsAwesomeHeaderException("Header required");
        }
    }

}
