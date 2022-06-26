package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PostRequestCheckerAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Around("execution(* com.example.aop.service.impl..*(..))\"")
    public Object logging(ProceedingJoinPoint jp) throws Throwable {

        if(httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME") == null){
            throw new AopIsAwesomeHeaderException("Header Required: AOP-IS-AWESOME");
        }
        return jp.proceed();
    }

}
