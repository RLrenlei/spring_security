package com.rl.spring_security.java8;

import java.lang.annotation.*;
import java.util.Optional;

/**
 * @author Ren
 * @description 测试重复注解
 * @date 2022/1/7 17:25
 */
public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    };

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {

    }

    public static void main(String[] args) {
//        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
//            System.out.println(filter.value());
//        }

        // 测试新方法Optional
//        Optional<String> fullName = Optional.ofNullable(null);
//        System.out.println("Full Name is Set? " + fullName.isPresent());
//        System.out.println("Full Name: " + fullName.orElseGet(()->"[none]"));
//        System.out.println(fullName.map(s->"Hey " + s + "!").orElse("Hey Stranger!"));
        Optional<String> firstName = Optional.of("Tom");
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("First Name: " + firstName.orElseGet(()->"[none]"));
        System.out.println(firstName.map(s->"Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println();
    }


}
