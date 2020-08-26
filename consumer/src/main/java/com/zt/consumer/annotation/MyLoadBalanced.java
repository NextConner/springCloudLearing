package com.zt.consumer.annotation;


import javax.inject.Qualifier;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier
public @interface MyLoadBalanced {
}
