package edu.miu.Lab05.aspect;

import edu.miu.Lab05.error.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AwesomeHeaderValidation {

    @Autowired
    private final HttpServletRequest httpServletRequest;

    public AwesomeHeaderValidation(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Pointcut("within(edu.miu.Lab05.service..*)")
    public void PostHeaderAspect(){}

    @Around("PostHeaderAspect()")
    public Object Logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        if(httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME")==null){
            throw new AopIsAwesomeHeaderException("Header is required");
        }

        return  proceedingJoinPoint.proceed();
    }

}
