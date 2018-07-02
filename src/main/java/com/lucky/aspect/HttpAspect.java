package com.lucky.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * User: xiaoran
 *
 * Date: 2018-07-01
 * Time: 17:46
 */
@Component
@Aspect
@Slf4j
public class HttpAspect {

    @Pointcut("execution(public * com.lucky.controller.*.*(..))")
    public void cut(){
    }

    @Around("cut()")
    public void aroundLog(ProceedingJoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        log.info("hello world");
        log.info("url ={}, method = {}  class_method={}  args={}",
                request.getRequestURI(),
                request.getMethod(),
                joinPoint.getSignature().getDeclaringTypeName() + '.' + joinPoint.getSignature().getName(),
                JSON.toJSONString(joinPoint.getArgs()));

        try{
            Object obj = joinPoint.proceed();
            log.info("response={}", JSON.toJSONString(obj));
        }catch (Throwable e){
            log.error("请求异常 {}",e);
        }
    }
}
