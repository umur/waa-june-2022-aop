package com.example.lab5.bidirectional.aspect;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class CheckPostAopAspect {
    @Pointcut("@annotation(com.example.lab5.bidirectional.aspect.annotations.CheckPostAOP)")
    //create a pointcut -> extract every method with the annotation
    public void a() {
    }

    @After("a()")
    public Object checkHeaderPost(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttribute;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        if (request.getHeader("AOP_IS_AWESOME") != null) {
            return proceedingJoinPoint.proceed();
        } else {
            throw new Exception("AOP is awesome");
        }
    }
}
