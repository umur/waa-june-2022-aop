package edu.miu.cs545.aop.aspect;

import edu.miu.cs545.aop.entity.ActivityLog;
import edu.miu.cs545.aop.repo.ActivityLogRepo;
import edu.miu.cs545.aop.utils.exception.AopIsAwesomeHeaderException;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Aspect
@Component
@AllArgsConstructor
public class AopIsAwesomeAspect {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut("within(edu.miu.cs545.aop.service..*)")
    public void serviceLocator(){}

    @Around("serviceLocator()")
    public Object headerChecker(ProceedingJoinPoint pjp)throws Throwable{
        if (httpServletRequest.getHeader("AOP-IS-AWESOME") == null&&httpServletRequest.getMethod().equals("POST")) {
            throw new AopIsAwesomeHeaderException("Header 'AOP-IS-AWESOME' Not Found");
        }
        return pjp.proceed();
    }
}
