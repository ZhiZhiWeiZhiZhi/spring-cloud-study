package org.f.study.spring.boot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.f.study.spring.common.util.LogUtil;
import org.springframework.stereotype.Component;

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

    @Before("cut()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        log.info(LogUtil.logStrBegin);
        String classMethod = "请求类及方法名:" + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName();
        LogUtil.requestLogInfo(classMethod);
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
        log.info("返回值:{}",obj);
        log.info("耗时:{}",System.currentTimeMillis()-startTime.get()+"ms");
        log.info(LogUtil.logStrEnd);
    }
}
