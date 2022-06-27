package com.example.lab3.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AopAwsomAspect {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut(value = "execution(* com.example.lab3.Service.Impl..*(..))")
    public void a(){}
    @Around("a()")
    public Object checkRequest(ProceedingJoinPoint jp) throws Throwable{
        if(httpServletRequest.getMethod().equals("Post")&& httpServletRequest.getHeader("AOP-IS-AWESOME")==null){
           throw new AopIsAwesomeHeaderException("header is required");
        }
        System.out.println(httpServletRequest.getMethod());
        return jp.proceed();
    }
}
