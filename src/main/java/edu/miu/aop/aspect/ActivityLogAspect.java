package edu.miu.aop.aspect;

import edu.miu.aop.entity.ActivityLog;
import edu.miu.aop.repo.ActivityLogRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Aspect
@Component
public class ActivityLogAspect {

    @Resource
    private ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(edu.miu.aop.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){}

    @After("executionTimeAnnotation()")
    public void log(JoinPoint joinPoint){
        System.out.println("Method Name:" + joinPoint.getSignature().getName());
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String sign = proceedingJoinPoint.getSignature().getName();
        String methodName = "Name of method : " + sign;

        long start = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();


        long duration = (finish-start);
        ActivityLog activityLog = new ActivityLog(LocalDateTime.now(), methodName, duration);
        activityLogRepo.save(activityLog);
        System.out.println("Duration of " + sign + " is "+ duration);

        return result;
    }
}
