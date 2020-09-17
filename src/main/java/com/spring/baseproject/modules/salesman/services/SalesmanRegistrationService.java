package com.spring.baseproject.modules.salesman.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.salesman.models.dtos.NewSalesmanDto;
import com.spring.baseproject.modules.salesman.models.entities.Salesman;
import com.spring.baseproject.modules.salesman.repositories.SalesmanRepository;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalesmanRegistrationService {
    @Autowired
    private SalesmanRepository salesmanRepository;

    @Autowired
    private UserRegistrationService userRegistrationService;


    @Transactional(rollbackFor = Exception.class)
    public BaseResponse registerNewSalesman(NewSalesmanDto newSalesmanDto) {

        User user = userRegistrationService.registerUser(newSalesmanDto);
        if (user == null) {
            return new BaseResponse(ResponseValue.USERNAME_EXISTS);
        }

        Salesman salesman = new Salesman(newSalesmanDto, user);
        if (salesman.getContactEmail() == null){
            salesman.setContactEmail(user.getUsername());
        }

        salesman.getUser().setUserType(newSalesmanDto.getUserType());
        salesmanRepository.save(salesman);
        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
