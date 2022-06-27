package edu.miu.springdata.aspect;

import edu.miu.springdata.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;

@Aspect
@Component
public class RequestAspectAspect {


    @Pointcut("@annotation(edu.miu.springdata.service.RequestInf)")
    public void excutionTimeAnnotation() {

    }

    @Around("excutionTimeAnnotation()")
    public Object calculateExcutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer sb = request.getRequestURL();

        if (!sb.toString().contains("AOP-IS-AWESOME")) {
            throw new Exception("AopIsAwesomeHeaderException");
        }

        System.out.println("POST requests has AOP-IS-AWESOME header. ");
        return request;
    }
}
