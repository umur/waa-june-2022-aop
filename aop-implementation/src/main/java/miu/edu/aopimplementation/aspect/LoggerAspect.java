package miu.edu.aopimplementation.aspect;

import miu.edu.aopimplementation.dto.ActivityLogDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;

public class LoggerAspect {
    @Autowired
    ActivityLogDto activityLog;

    @After("@annotation(miu.edu.aopimplementation.aspect.annotation.LogMe)")//this is another way
    public void log(JoinPoint joinPoint) {
        activityLog.setOperation(Long.valueOf(joinPoint.getSignature().getName())); //setting the operation


    }
}
