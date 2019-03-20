package org.f.study.spring.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * description
 *
 * @author f
 * @date 2019/3/20 10:23
 **/
@Slf4j
public class DateUtil {

    private static final String yyyyMMddhhmmss="yyyy-MM-dd hh:mm:ss";

    public static String now(){
        return DateFormatUtils.format(new Date(),yyyyMMddhhmmss);
    }

    public static void main(String[] args) {
        log.info(now());
    }
}
