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

        //ctx.close();

        //After closing ctx above line will give an error
        /*Customer customer3 = ctx.getBean(Customer.class);
        System.out.println(customer3);*/

        //For a solution for this we can use shutdown hook
        /*Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("JVM is about to shutdown");
                ctx.close();
            }
        }));

        //Now above lines will be executed without an error
        Customer customer4 = ctx.getBean(Customer.class);
        System.out.println(customer4);*/

        //Spring simplyfy above method
        //This method will close the container just before JVM shutdown
        ctx.registerShutdownHook();

        //Now spring do the same process
        Customer customer5 = ctx.getBean(Customer.class);
        System.out.println(customer5);
    }
}
