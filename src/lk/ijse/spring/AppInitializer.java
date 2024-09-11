package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.BasicDataSource;
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

        //Making an unowned class a POJO
        //@Bean annotation
        BasicDataSource basicDataSource1 = ctx.getBean(BasicDataSource.class);
        System.out.println(basicDataSource1);
        BasicDataSource basicDataSource2 = ctx.getBean(BasicDataSource.class);
        System.out.println(basicDataSource2);

        ctx.close();
    }
}
