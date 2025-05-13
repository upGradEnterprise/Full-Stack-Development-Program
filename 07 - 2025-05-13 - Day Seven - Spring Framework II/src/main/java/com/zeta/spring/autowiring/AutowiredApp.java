package com.zeta.spring.autowiring;

import com.zeta.spring.autowiring.bean.TeamLead;
import com.zeta.spring.autowiring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TeamLead teamLead = context.getBean(TeamLead.class);
        teamLead.sayHello();
        context.close();
    }
}
