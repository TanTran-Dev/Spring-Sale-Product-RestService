package com.spring.baseproject.modules.customer.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public BaseResponse getCustomerDto(String customerId){
        CustomerDto customerDto = customerRepository.getCustomerDto(customerId);
        if (customerDto == null){
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, customerDto);
    }
}
