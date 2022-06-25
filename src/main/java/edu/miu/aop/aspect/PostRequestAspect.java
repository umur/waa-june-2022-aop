package edu.miu.aop.aspect;

import edu.miu.aop.exeption.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class PostRequestAspect {

    @Resource
    private HttpServletRequest httpServletRequest;

    @Around("execution(* edu.miu.aop.service.impl.*.*(..))")
    public Object checkPost(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if(httpServletRequest.getHeader("AOP-IS-AWESOME") == null
            && httpServletRequest.getMethod().equals("POST")){
            throw new AopIsAwesomeHeaderException("Error: header(AOP-IS-AWESOME) is not found");
        }

        return proceedingJoinPoint.proceed();
    }
}
