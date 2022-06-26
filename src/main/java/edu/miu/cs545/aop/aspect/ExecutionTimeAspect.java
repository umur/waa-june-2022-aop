package edu.miu.cs545.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExecutionTimeAspect {

    @Around("@annotation(edu.miu.cs545.aop.aspect.annotation.ExecutionTime)")
    public Object calculateExecutationTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start=System.nanoTime();
        var result=proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() +"takes ns" + (finish-start));
        return result;
    }
}
