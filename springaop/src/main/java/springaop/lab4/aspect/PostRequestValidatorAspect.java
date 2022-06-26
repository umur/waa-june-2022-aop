package springaop.lab4.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import springaop.lab4.exception.AopIsAwesomeHeaderException;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class PostRequestValidatorAspect {

    private HttpServletRequest httpServletRequest;

    @Pointcut(value = "execution(* springaop.lab4.service.impl.impl..*(..))")
    public void getPointCut(){

    }
    @Around("getPointCut()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        if (httpServletRequest.getMethod().equals("Post")&&
                httpServletRequest.getHeader("AOP-IS-AWESOME")==null){
            throw  new AopIsAwesomeHeaderException("Header is required");
        }
        return joinPoint.proceed();
    }
}
