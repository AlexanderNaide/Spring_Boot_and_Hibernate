package ru.gb.spring_boot_and_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_boot_and_hibernate.model.Customer;
import ru.gb.spring_boot_and_hibernate.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findByNumber(String number) {
        return customerRepository.findByPhoneNumber(number);
    }

    public Optional<Customer> findOldest() {
        return customerRepository.findOldest();
    }

    public List<Customer> searchByNumber(String number) {
        return customerRepository.findByPhoneNumberContaining(number);
    }
}
