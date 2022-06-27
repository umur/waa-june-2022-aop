package edu.miu.cs545.aop.aspect;

import edu.miu.cs545.aop.entity.ActivityLog;
import edu.miu.cs545.aop.repo.ActivityLogRepo;
import edu.miu.cs545.aop.utils.exception.AopIsAwesomeHeaderException;
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
public class AopIsAwesomeAspect {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private ActivityLogRepo activityLogRepo;
//    @Around("@annotation(edu.miu.cs545.aop.aspect.annotation.ExecutionTime)")

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void serviceLocator(){}

    @Around("serviceLocator()")
    public Object headerChecker(ProceedingJoinPoint pjp)throws Throwable{
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        if (request.getHeader("AOP-IS-AWESOME") != null) {
            long start = System.nanoTime();
            var result = pjp.proceed();
            long finish = System.nanoTime();
            activityLogRepo.save(new ActivityLog(LocalDate.now(),pjp.getSignature().getName(),finish-start));
            return result;
        }
        else {
            System.out.println("HERE I AM IN AOP IS AWESOME");
            throw new AopIsAwesomeHeaderException("Header 'AOP-IS-AWESOME' Not Found");
        }
    }
}
