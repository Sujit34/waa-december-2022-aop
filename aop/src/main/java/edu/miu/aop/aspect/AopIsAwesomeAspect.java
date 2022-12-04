package edu.miu.aop.aspect;

import edu.miu.aop.exception.AopIsAwesomeHeaderException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class AopIsAwesomeAspect {
    private final HttpServletRequest request;

    @Before("execution(* edu.miu.aop.service.*.*(..))")
    public void aopIsAwesomeJoinPoint(JoinPoint jp){
        if(request.getMethod().equals("POST") && request.getHeader("AOP-IS-AWESOME") == null){
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME is required");
        }
    }
}
