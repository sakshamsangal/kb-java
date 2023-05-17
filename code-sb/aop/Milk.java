package com.example.demo.aop;


import com.fasterxml.jackson.databind.*;
import lombok.extern.slf4j.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

@Aspect
@Component
@Slf4j
public class Milk {


    @Pointcut(value = "execution(* com.example.controller.*.*(..) )")
    public void myPointcut() {

    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        log.info("=================================");
        log.info("Unified logging");
        log.info("methodName = " + methodName);
        log.info("className = " + className);
        log.info("Unified logging request: " + mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        log.info("Unified logging response: " + mapper.writeValueAsString(object));
        log.info("=================================");
        return object;
    }

}