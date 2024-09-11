package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    public Customer() {
        System.out.println("Customer : Instantiated");
    }

    public void getCustomerName() {
        System.out.println("getCustomerName Method Invoked");
    }
}
