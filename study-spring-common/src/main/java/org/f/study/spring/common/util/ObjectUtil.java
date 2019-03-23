package org.f.study.spring.common.util;


import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

/**
 * description
 *
 * @author f
 * @date 2019/3/20 10:40
 **/
public class ObjectUtil extends ObjectUtils {
    public static boolean isNotEmpty(@Nullable Object obj) {
        return isEmpty(obj)?false:true;
    }
}
