package com.spring.baseproject.modules.customer.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.services.UserRegistrationService;
import com.spring.baseproject.modules.customer.models.dtos.NewCustomerDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerRegistrationService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRegistrationService userRegistrationService;


    @Transactional(rollbackFor = Exception.class)
    public BaseResponse registerNewCustomer(NewCustomerDto newCustomerDto) {

        User user = userRegistrationService.registerUser(newCustomerDto);
        if (user == null) {
            return new BaseResponse(ResponseValue.USERNAME_EXISTS);
        }

        Customer customer = new Customer(newCustomerDto, user);

        if (customer.getContactEmail() == null){
            customer.setContactEmail(user.getUsername());
        }
        customer.getUser().setUserType(newCustomerDto.getUserType());

        customerRepository.save(customer);
        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
