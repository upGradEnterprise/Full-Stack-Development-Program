package com.zeta.spring.ioc;

import com.zeta.spring.ioc.bean.*;
import com.zeta.spring.ioc.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CtoDepartment ctoDepartment = context.getBean(CtoDepartment.class);
        System.out.println(ctoDepartment);

        HrDepartment hrDepartment = context.getBean(HrDepartment.class);
        System.out.println(hrDepartment);

        SupportDepartment supportDepartment = context.getBean(SupportDepartment.class);
        System.out.println(supportDepartment);

        context.close();
    }
}