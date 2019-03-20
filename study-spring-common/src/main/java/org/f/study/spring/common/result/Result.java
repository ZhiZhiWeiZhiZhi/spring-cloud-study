package org.f.study.spring.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * description
 *
 * @author f
 * @date 2019/3/20 14:56
 **/
@Data
public class Result implements Serializable {
    private String code;
    private String msg;
    private Object object;

    public Result(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public Result(String code,String msg,Object object){
        this.code=code;
        this.msg=msg;
        this.object=object;
    }

    public static Result success(){
        return new Result("40000","success");
    }
    public static Result success(String msg){
        return new Result("40000",msg);
    }
    public static Result success(String msg,Object object){
        return new Result("40000",msg,object);
    }

    public static Result fail(){
        return new Result("40002","fail");
    }
    public static Result fail(String msg){
        return new Result("40002",msg);
    }


    public static Result business(String msg){
        return new Result("40003",msg);
    }

    public static Result result(String code,String msg){
        return new Result(code,msg);
    }
}
