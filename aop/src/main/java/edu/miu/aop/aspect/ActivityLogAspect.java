package edu.miu.aop.aspect;


import edu.miu.aop.dto.ActivityLogDto;
import edu.miu.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ActivityLogAspect {
    private final ActivityLogService activityLogService;

    @Around("@annotation(edu.miu.aop.aspect.annotation.ExecutionTime)")
    public Object activityLogJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        ActivityLogDto al = new ActivityLogDto();

        var startTime = System.nanoTime();
        var result = joinPoint.proceed();
        var endTime = System.nanoTime();

        al.setDate(LocalDate.now());
        al.setOperation(joinPoint.getSignature().getName());
        al.setDuration(startTime-endTime);

        activityLogService.save(al);

        return result;

    }

}
