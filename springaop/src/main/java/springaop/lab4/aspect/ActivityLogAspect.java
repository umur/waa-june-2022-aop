package springaop.lab4.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import springaop.lab4.domain.ActivityLog;
import springaop.lab4.repository.ActivityLogRepository;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {
    private ActivityLogRepository activityLogRepository;


    @Pointcut("@annotation(springaop.lab4.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {

    }
@Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = joinPoint.proceed();
        long end = System.nanoTime();

        String packageName=joinPoint.getSignature().getDeclaringTypeName();
        String methodName =joinPoint.getSignature().getName();
        ActivityLog activityLog= new ActivityLog(LocalDate.now(),
                String.format("Class: %s, method: %s",
                        packageName,methodName),(end-start));
                      activityLogRepository.save(activityLog);
    return result;
}

}