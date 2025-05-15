package com.zeta.spring.scope.prototype;

import com.zeta.spring.scope.prototype.bean.Actor;
import com.zeta.spring.scope.prototype.bean.Bachchan;
import com.zeta.spring.scope.prototype.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopePrototypeApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Actor amitabhBachchan = context.getBean(Bachchan.class);
        Actor abhishekhBachchan = context.getBean(Bachchan.class);
        Actor aishwaryaBachchan = context.getBean(Bachchan.class);

        amitabhBachchan.canAct(true);
        amitabhBachchan.canDance(false);
        amitabhBachchan.hasAward(true);

        abhishekhBachchan.canAct(true);
        abhishekhBachchan.canDance(false);
        abhishekhBachchan.hasAward(false);

        aishwaryaBachchan.canAct(true);
        aishwaryaBachchan.canDance(true);
        aishwaryaBachchan.hasAward(true);

        System.out.println("Amitabh Bachchan");
        System.out.println("Actor can Act? " + amitabhBachchan.getAct());
        System.out.println("Actor can Dance? " + amitabhBachchan.getDance());
        System.out.println("Actor has Award? " + amitabhBachchan.getAward());
        System.out.println();
        System.out.println("Abhishesk Bachchan");
        System.out.println("Actor can Act? " + abhishekhBachchan.getAct());
        System.out.println("Actor can Dance? " + abhishekhBachchan.getDance());
        System.out.println("Actor has Award? " + abhishekhBachchan.getAward());
        System.out.println();
        System.out.println("Aishwarya Bachchan");
        System.out.println("Actor can Act? " + aishwaryaBachchan.getAct());
        System.out.println("Actor can Dance? " + aishwaryaBachchan.getDance());
        System.out.println("Actor has Award? " + aishwaryaBachchan.getAward());
        System.out.println();

        context.close();
    }
}