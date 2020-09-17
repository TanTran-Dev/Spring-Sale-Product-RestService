package com.spring.baseproject.modules.salesman.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.salesman.models.dtos.SalesmanDto;
import com.spring.baseproject.modules.salesman.models.dtos.NewSalesmanDto;
import com.spring.baseproject.modules.salesman.models.entities.Salesman;
import com.spring.baseproject.modules.salesman.repositories.SalesmanRepository;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService {
    @Autowired
    private SalesmanRepository salesmanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public BaseResponse getSalesmanDto(String salesmanId){
        SalesmanDto salesmanDto = salesmanRepository.getSalesmanDto(salesmanId);
        if (salesmanDto == null){
            return new BaseResponse(ResponseValue.SALESMAN_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, salesmanDto);
    }

    public BaseResponse updateSalesman(String salesmanId, NewSalesmanDto newAdminProfileDto){
        Salesman salesman = salesmanRepository.findFirstById(salesmanId);
        if (salesman == null){
            return new BaseResponse(ResponseValue.SALESMAN_NOT_FOUND);
        }

        User user = userRepository.findFirstById(salesmanId);
        user.setUsername(newAdminProfileDto.getUsername());
        user.setPassword(passwordEncoder.encode(newAdminProfileDto.getPassword()));
        user.setUserType(newAdminProfileDto.getUserType());

        salesman.setUser(user);
        salesman.update(newAdminProfileDto);
        salesmanRepository.save(salesman);

        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
