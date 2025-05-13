package com.zeta.spring.ioc;

import com.zeta.spring.ioc.bean.Car;
import com.zeta.spring.ioc.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SetterInjectionTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = (Car) context.getBean(Car.class);
        System.out.println(car.getEngineType());
        context.close();
    }
}