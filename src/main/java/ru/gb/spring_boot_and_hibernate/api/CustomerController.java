package ru.gb.spring_boot_and_hibernate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.spring_boot_and_hibernate.model.Customer;
import ru.gb.spring_boot_and_hibernate.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
//        Optional<Customer> customerOptional = customerService.findById(id);
        return customerService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/by_number")
    public Customer findByNumber(@RequestParam String number){
        return customerService.findByNumber(number).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/oldest")
    public Customer findOldest(){
        return customerService.findOldest().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public List<Customer> searchByNumber(@RequestParam String number){
        return customerService.searchByNumber(number);
    }

}
