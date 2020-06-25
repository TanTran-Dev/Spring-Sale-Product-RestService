package com.spring.baseproject.modules.customer.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.repositories.UserRepository;
import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.customer.models.dtos.NewCustomerDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public BaseResponse getCustomerDto(String customerId) {
        CustomerDto customerDto = customerRepository.getCustomerDto(customerId);
        if (customerDto == null) {
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, customerDto);
    }

    public BaseResponse updateProfileCustomer(String customerId, NewCustomerDto newCustomerProfileDto) {
        Customer customer = customerRepository.findFirstById(customerId);
        if (customer == null) {
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }

        User user = userRepository.findFirstById(customerId);
        user.setUsername(newCustomerProfileDto.getUsername());
        user.setPassword(passwordEncoder.encode(newCustomerProfileDto.getPassword()));
        user.setUserType(newCustomerProfileDto.getUserType());

        customer.setUser(user);
        customer.update(newCustomerProfileDto);
        customerRepository.save(customer);

        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
