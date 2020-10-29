package org.f.study.spring.common.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.f.study.spring.common.annotation.LogSet;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author f
 */
@Slf4j
public class LogUtil {


    public static void requestLogInfo(Object returnObj, Long time, LogSet logSet) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();
        String uuid = UUID.randomUUID().toString();

        boolean requestLog = null == logSet || (null != logSet && logSet.requestLog());
        if(requestLog) {
            log.info(uuid + " url:{}", requestUrl(request));
            log.info(uuid + " from:{}", requestClient(request));
            log.info(uuid + " RequestParam:{}", requestArgs(request));
        }
        boolean responseLog = null == logSet || (null != logSet && logSet.responseLog());
        if(responseLog) {
            log.info(uuid + " return:{}", returnObj);
        }
        log.info(uuid + " time:{}", time + "ms");
    }
    public static String requestLogError() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();
        String uuid = UUID.randomUUID().toString();
        log.info(uuid + " url:{}" , requestUrl(request));
        log.info(uuid + " from:{}" , requestClient(request));
        log.info(uuid + " RequestParam:{}" , requestArgs(request));
        return uuid;
    }

    public static String requestUrl(HttpServletRequest request) {
        return request.getMethod() + " " + request.getRequestURL();
    }

    public static String requestClient(HttpServletRequest request) {
        return "from:"
                + "IP:" + HttpUtil.getIpAddress(request)
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
        return "" + JSON.toJSONString(map);
    }

    public static String replaceEmail(String str){
        return str.replaceAll("(?<=\\w{3})(\\w+)(?=@\\w+)", "****");
    }

    public static String replacePassword(String str){
        return str.replaceAll("password.*?([,}$])", "password=****,");
    }

}
