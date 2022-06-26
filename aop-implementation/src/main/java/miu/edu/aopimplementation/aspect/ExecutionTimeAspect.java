package miu.edu.aopimplementation.aspect;

import miu.edu.aopimplementation.dto.ActivityLogDto;
import miu.edu.aopimplementation.exception.AopIsAwesomeHeaderException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    ActivityLogDto activityLog;
    @Pointcut("@annotation(miu.edu.aopimplementation.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){}

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + "takes ns:" + finish) ;
        activityLog.setOperation(finish-start);
        return result;
    }
}
