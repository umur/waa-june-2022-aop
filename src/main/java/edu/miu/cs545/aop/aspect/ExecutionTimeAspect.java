package edu.miu.cs545.aop.aspect;

import edu.miu.cs545.aop.entity.ActivityLog;
import edu.miu.cs545.aop.service.ActivityLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    private ActivityLogService activityLogService;

    @Around("@annotation(edu.miu.cs545.aop.aspect.annotation.ExecutionTime)")
    public Object calculateExecutationTime(ProceedingJoinPoint pjp) throws Throwable {
        long start=System.nanoTime();
        var result=pjp.proceed();
        long finish = System.nanoTime();
        activityLogService.saveLog(new ActivityLog(LocalDate.now(),pjp.getSignature().getName(),(finish-start)/1000000000));
        return result;
    }
}
