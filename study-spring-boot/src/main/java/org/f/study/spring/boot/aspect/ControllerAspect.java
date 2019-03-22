package org.f.study.spring.boot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *
 * @author f
 * @date 2019/3/21 11:18
 **/
@Aspect
@Component
@Slf4j
public class ControllerAspect {


    @Pointcut("execution(public * org.f.study.spring.boot.controller.*.*(..))")
    public void cut(){
    }

    @Before("cut()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();
        //url
        log.info("url ={}",request.getRequestURI());
        //method
        log.info("method={}",request.getMethod());
        //ip
        log.info("ip={}",request.getRemoteAddr());
        //类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+'.'+ joinPoint.getSignature().getName());//获取类名及类方法
        //参数
        log.info("args={}",joinPoint.getArgs());
    }

    /**
     * 无论Controller中调用方法以何种方式结束，都会执行
     */
    @After("cut()")
    public void doAfter(){}

    /**
     * 在调用上面 @Pointcut标注的方法后执行。用于获取返回值
     * @param obj
     */
    @AfterReturning(returning = "obj",pointcut = "cut()")
    public void doAfterReturning(Object obj){
        log.info("response={}",obj);
    }
}
