package edu.miu.cs545.aop.aspect;

import edu.miu.cs545.aop.entity.ActivityLog;
import edu.miu.cs545.aop.repo.ActivityLogRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Aspect
public class ExecutionTimeAspect {
    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Around("@annotation(edu.miu.cs545.aop.aspect.annotation.ExecutionTime)")
    public Object calculateExecutationTime(ProceedingJoinPoint pjp) throws Throwable {
        long start=System.nanoTime();
        var result=pjp.proceed();
        long finish = System.nanoTime();
        activityLogRepo.save(new ActivityLog(LocalDate.now(),pjp.getSignature().getName(),finish-start));
        return result;
    }
}
