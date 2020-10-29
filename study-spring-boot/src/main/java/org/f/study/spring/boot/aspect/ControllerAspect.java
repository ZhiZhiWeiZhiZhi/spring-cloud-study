package org.f.study.spring.boot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.f.study.spring.common.annotation.LogSet;
import org.f.study.spring.common.util.LogUtil;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * org.f.study.spring.boot.controller.*.*(..))")
    public void cut(){
    }

    @Pointcut("@annotation(org.f.study.spring.common.annotation.LogSet)")
    public void cut2(){
    }

    @Before("cut()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
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
    @AfterReturning(returning = "obj",pointcut = "cut() || cut2()")
    public void doAfterReturning(JoinPoint joinPoint,Object obj){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogSet logSet = method.getAnnotation(LogSet.class);
        Long time = System.currentTimeMillis() - startTime.get();
        startTime.remove();
        LogUtil.requestLogInfo(obj,time,logSet);
    }
}
