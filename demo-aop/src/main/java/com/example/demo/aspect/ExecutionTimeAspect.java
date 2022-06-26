package com.example.demo.aspect;

import com.example.demo.entity.ActivityLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
  @Autowired
  ActivityLog activityLog;

  @Around("@annotation(com.example.demo.aspect.annotations.ExecutionTime)")
  public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    long start = System.nanoTime();
    Object result = proceedingJoinPoint.proceed();
    long finish = System.nanoTime();
    System.out.println(proceedingJoinPoint.getSignature().getName() + "takes ns: " + (finish - start));
    activityLog.setOperation(finish - start);
    return result;
  }


}
