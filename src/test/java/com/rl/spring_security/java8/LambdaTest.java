package com.rl.spring_security.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Ren
 * @description 测试Lambda表达式的语法
 * @date 2022/1/7 15:44
 */
public class LambdaTest {

    public static void main(String[] args) {
        String str = "a,b,c,d";
        List<String> list = Arrays.asList(str.split(","));
        List<Integer> numList = Arrays.asList(2,5,1,8,7);
        // 简单遍历list
        list.forEach(item -> {
            if ("b".equals(item))
                System.out.println(item);
        });
        numList.sort(Comparator.reverseOrder());
        System.out.println(numList);

        // 构造器引用 语法Class<T>::new, 没有参数
        final Car car = Car.create(Car::new);
        final List<Car> cars = Collections.singletonList(car);
        // 静态方法引用 语法Class::static_method, 该方法接受一个Car类型的参数
        cars.forEach(Car::collide);
        // 引用某个类的成员方法，没有入参
        cars.forEach(Car::repair);
        // 引用某个实例对象的成员方法
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

    // 测试方法引用
    public static class Car {
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }
}


