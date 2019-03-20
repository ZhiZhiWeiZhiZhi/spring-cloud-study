package org.f.study.spring.common.exception;

import lombok.Data;
import org.f.study.spring.common.result.Result;

/**
 * description
 *
 * @author f
 * @date 2019/3/20 15:32
 **/
@Data
public class BusinessException extends RuntimeException{
    private Result result;
    public BusinessException(String msg){
        this.result = Result.business(msg);
    }
    public BusinessException(String code,String msg){
        this.result = Result.result(code,msg);
    }
}
