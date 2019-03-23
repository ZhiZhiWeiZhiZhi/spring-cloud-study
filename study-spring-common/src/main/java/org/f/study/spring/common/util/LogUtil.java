package org.f.study.spring.common.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author f
 */
@Slf4j
public class LogUtil {

    public final static String logStrBegin = "-------------------------请求开始-------------------------";
    public final static String logStrEnd = "-------------------------请求完成-------------------------";


    public static void requestLogInfo(String classMethod) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();
        log.info(requestPath(request));
        log.info(requestMethod(request));
        log.info(classMethod);
        log.info(requestClient(request));
        log.info(requestArgs(request));
    }
    public static void requestLogError() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();

        log.error(requestPath(request));
        log.error(requestMethod(request));
        log.error(requestClient(request));
        log.error(requestArgs(request));
    }

    public static String requestMethod(HttpServletRequest request) {
        return "HTTP 请求方法:" + request.getMethod();
    }

    public static String requestPath(HttpServletRequest request) {
        return "请求地址:" + request.getRequestURL();
    }

    public static String requestClient(HttpServletRequest request) {
        return "请求客户端:" + "Time:" + DateUtil.now()
                + " , IP:" + HttpUtil.getIpAddress(request)
                + " , Agent:" + HttpUtil.getUserAgent(request);
    }

    public static String requestArgs(HttpServletRequest request) {
        Map map = new HashMap<>(request.getParameterMap());
        if(null != map){
            if (ObjectUtil.isNotEmpty(map.get("password"))) {
                map.put("password", "***");
            }
            if (ObjectUtil.isNotEmpty(map.get("paypassword"))) {
                map.put("paypassword", "***");
            }
            if (ObjectUtil.isNotEmpty(map.get("PASSWORD"))) {
                map.put("PASSWORD", "***");
            }
            if (ObjectUtil.isNotEmpty(map.get("oldpassword"))) {
                map.put("oldpassword", "***");
            }
            if (ObjectUtil.isNotEmpty(map.get("newpassword"))) {
                map.put("newpassword", "***");
            }
        }
        return "请求参数:" + JSON.toJSONString(map);
    }


}
