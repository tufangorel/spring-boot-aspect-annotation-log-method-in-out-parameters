package com.company.customerinfo.config.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(com.company.customerinfo.config.annotation.LogMethodExecutionTime)")
    public Object logMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String insidePackage = methodSignature.getDeclaringType().getPackageName();
        String insideClass = methodSignature.getDeclaringType().getSimpleName();
        String method = methodSignature.getName();

        String[] argNames = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterNames();
        Object[] values = proceedingJoinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        if (argNames.length != 0) {
            for (int i = 0; i < argNames.length; i++) {
                params.put(argNames[i], values[i]);
            }
        }

        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        LOGGER.info("-------------------------------");
        LOGGER.info("Start Log for @Around advice execution for LogMethodExecutionTime annotation");
        LOGGER.info("Total time for method execution " + insidePackage + "."+ insideClass + "." + method + " "
                + "took --> " + stopWatch.getTotalTimeMillis() + " ms");
        LOGGER.info("Method Input Parameters : "+params.toString());
        LOGGER.info("Method Output Parameters : "+result.toString());
        LOGGER.info("End Log for @Around advice execution for LogMethodExecutionTime annotation");
        LOGGER.info("-------------------------------");

        return result;
    }

    @Around("execution(* com.company.customerinfo.service..*(..))")
    public Object analyzeMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String insidePackage = methodSignature.getDeclaringType().getPackageName();
        String insideClass = methodSignature.getDeclaringType().getSimpleName();
        String method = methodSignature.getName();

        String[] argNames = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterNames();
        Object[] values = proceedingJoinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        if (argNames.length != 0) {
            for (int i = 0; i < argNames.length; i++) {
                params.put(argNames[i], values[i]);
            }
        }

        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        LOGGER.info("-------------------------------");
        LOGGER.info("Start Log for @Around advice execution");
        LOGGER.info("Total time for method execution " + insidePackage + "."+ insideClass + "." + method + " "
                    + "took --> " + stopWatch.getTotalTimeMillis() + " ms");
        LOGGER.info("Method Input Parameters : "+params.toString());
        LOGGER.info("Method Output Parameters : "+result.toString());
        LOGGER.info("End Log for @Around advice execution");
        LOGGER.info("-------------------------------");

        return result;
    }

    @AfterReturning( value = "execution(* com.company.customerinfo.service..*(..))", returning = "retVal")
    public void logAfterReturningAllMethods(JoinPoint joinPoint, Object retVal){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        //Get intercepted method details
        String insidePackage = methodSignature.getDeclaringType().getPackageName();
        String insideClass = methodSignature.getDeclaringType().getSimpleName();
        String method = methodSignature.getName();

        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        Object[] values = joinPoint.getArgs();
        Map<String, Object> params = new HashMap<>();
        if (argNames.length != 0) {
            for (int i = 0; i < argNames.length; i++) {
                params.put(argNames[i], values[i]);
            }
        }

        LOGGER.info("-------------------------------");
        LOGGER.info("Start Log for @AfterReturning advice execution");
        LOGGER.info("Executing method " + insidePackage + "."+ insideClass + "." + method + " ");
        LOGGER.info("Method Input Parameters : "+params.toString());
        LOGGER.info("Method Output Parameters : "+retVal.toString());
        LOGGER.info("End Log for @AfterReturning advice execution");
        LOGGER.info("-------------------------------");
    }

}
