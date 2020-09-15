package com.spring.baseproject.modules.customer.repositories;


import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    boolean existsByUser_Username(String username);

    Customer findFirstById(String id);

    @Query("select new com.spring.baseproject.modules.customer.models.dtos.CustomerDto" +
            "(c.id, c.firstName, c.lastName, c.address,c.birthDay, c.phone, c.gender, c.avatarUrl, c.imageCoverUrl)" +
            "from Customer c " +
            "where c.id = ?1")
    CustomerDto getCustomerDto(String customerId);
}
