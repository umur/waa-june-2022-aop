package edu.miu.aop.aspect;

import edu.miu.aop.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AwesomeHeaderValidation {
    private final HttpServletRequest httpServletRequest;

    public AwesomeHeaderValidation(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Pointcut("@annotation(edu.miu.aop.aspect.annotation.ExecutionTime)")
    public void postHeaderAspect() {
    }

    @Around("postHeaderAspect()")
    public Object logging(ProceedingJoinPoint jp) throws Throwable {
        if (httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME") == null) {
            throw new AopIsAwesomeHeaderException("Header is required");
        }
        return jp.proceed();
    }
}