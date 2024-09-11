package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        //same reference is printing here
        //that means accessing a single object
        Customer customer1 = ctx.getBean(Customer.class);
        System.out.println(customer1);
        customer1.getCustomerName();
        Customer customer2 = ctx.getBean(Customer.class);
        System.out.println(customer2);
        customer2.getCustomerName();

        ctx.close();
    }
}
