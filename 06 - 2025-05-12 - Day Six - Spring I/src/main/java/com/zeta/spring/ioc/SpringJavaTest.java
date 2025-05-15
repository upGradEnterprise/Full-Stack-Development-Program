package com.zeta.spring.ioc;

import com.zeta.spring.ioc.bean.Product;
import com.zeta.spring.ioc.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Product product = (Product) context.getBean(Product.class);
        product.setName("Laptop");
        System.out.println(product.getName());
    }
}