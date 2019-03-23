package org.f.study.spring.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.f.study.spring.common.result.Result;
import org.f.study.spring.common.util.LogUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一公共异常处理
 *
 * @author f
 * @date 2019/3/20 14:49
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        LogUtil.requestLogError();
        if (e instanceof BusinessException) {
            Result result = ((BusinessException) e).getResult();
            log.error("business_error_code:" + result.getCode());
            log.error("business_error_msg:" + result.getMsg());
            log.error("business_error_object:" + result.getObject());
            return result;
        } else {
            log.error("system_error", e);
            if(log.isDebugEnabled()) {
                return Result.fail("系统异常，请您联系管理员！</br>" +
                        e.getStackTrace()[0].getFileName() + "</br>" +
                        e.getStackTrace()[0].getLineNumber() + "</br>" +
                        e.toString());
            }
            return Result.success("系统异常，请您联系管理员！");
        }
    }
}
