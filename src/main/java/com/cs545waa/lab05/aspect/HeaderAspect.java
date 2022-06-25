package com.cs545waa.lab05.aspect;

import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.rmi.NoSuchObjectException;

@Aspect
@Component
@AllArgsConstructor
public class HeaderAspect {
    @Pointcut("within(com.cs545waa.lab05.service..*)")
    public void a(){}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void b(){}

    @Around("b()")
    public Object checkHeader(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        if(request.getHeader("AOP-IS-AWESOME")!=null)
            return proceedingJoinPoint.proceed();
        else
        throw new NoSuchObjectException("No such string in Header");
    }
}
