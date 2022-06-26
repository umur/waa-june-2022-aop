package miu.edu.aop.aspect;

import miu.edu.aop.domain.ActivityLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    ActivityLog activityLog;

    @Around("@annotation(miu.edu.aop.aspect.annotation.ExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + "takes ns: " + (finish - start));
        activityLog.setOperation(finish - start);
        return result;
    }


}
