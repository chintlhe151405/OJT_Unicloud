package com.example.demoexception_2.aspect;

import com.example.demoexception_2.utils.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        ObjectMapper mapper = new ObjectMapper();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();

        log.info("Method invoke " + className + StringUtils.COLON_CHARACTER + methodName +
                StringUtils.CLOSE_CHARACTER + "Param: "
                + mapper.writeValueAsString(array));

        Object object = proceedingJoinPoint.proceed();

        log.info(className + StringUtils.COLON_CHARACTER + methodName +
                StringUtils.CLOSE_CHARACTER + "\n Response: "
                + mapper.writeValueAsString(object));
        return object;
    }

    @Pointcut(value = "execution(* com.example.demoexception_2.*.*.*.*(..))")
    public void myPointCut() {

    }



}
