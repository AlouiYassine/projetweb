package tn.esprit.spring.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @AfterReturning("execution(* tn.esprit.spring.services.*.get*(..))")
    public void logMethodReturning(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info(name + " Bon Courage! ");
    }
}

