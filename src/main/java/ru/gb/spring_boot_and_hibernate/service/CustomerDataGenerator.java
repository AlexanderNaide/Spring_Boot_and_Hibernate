package ru.gb.spring_boot_and_hibernate.service;

//import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.spring_boot_and_hibernate.model.Customer;
import ru.gb.spring_boot_and_hibernate.repository.CustomerRepository;

@Component
public class CustomerDataGenerator {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void generateDataOnStartup(){
//        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
//            customer.setName(faker.name().fullName());
            customer.setName("user" + i);

//            customer.setPhoneNumber(faker.number().digits(9));
            customer.setPhoneNumber("8-999-228-" + (1234 + i * 927));

//            customer.setAge(faker.number().numberBetween(20, 60));
            customer.setAge(20 + (3 * i));

            customerRepository.save(customer);
        }
    }

}
