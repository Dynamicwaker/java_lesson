package com.dynamic.interview.reflect;

import java.lang.annotation.*;

/**
 * @author:xinghj0308@gmail.com
 * @create:2021/5/29
 * @description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    int id() default -1;

    String name() default "";

    String address() default "";
}


