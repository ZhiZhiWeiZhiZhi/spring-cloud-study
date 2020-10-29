package org.f.study.spring.common.annotation;

import java.lang.annotation.*;

/**
 * @author f
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogSet {
    boolean requestLog();
    boolean responseLog();
}
