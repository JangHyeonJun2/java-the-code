package com.ims.owen.javathecode;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited // 상속이 되는 어노테이션
public @interface MyAnnotation {

    String name() default "Owen";
    int value() default 0;
}
