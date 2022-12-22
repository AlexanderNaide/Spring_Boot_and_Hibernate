package ru.gb.spring_boot_and_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.spring_boot_and_hibernate.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Как генерить подобные запросы подробно расписано
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface
    Optional<Customer> findByPhoneNumber(String number);



    // Когда не нужно, чтобы spring мапил запрос, а использовал написанный запрос - ставим @Query и в параметрах тот запос который надо выполнить в методе
    @Query("select c from Customer c where c.age = (select max(c2.age) from Customer c2)")                                       // так запрос в HQL
//    @Query(nativeQuery = true, value = "SELECT * FROM customer c where age = (select max(c2.age) from customer c2);")          // так запрос в SQL
//    @Query(value = "SELECT * FROM customer c where age = (select max(c2.age) from customer c2);", nativeQuery = true)          // или так запрос в SQL
    Optional<Customer> findOldest();


    //Поиск по "неполному" слову, по типу Like в лексике Spring - это Containing
    List<Customer> findByPhoneNumberContaining(String number);
}
