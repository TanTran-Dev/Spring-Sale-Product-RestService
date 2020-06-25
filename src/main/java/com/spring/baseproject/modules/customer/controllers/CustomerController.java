package com.spring.baseproject.modules.customer.controllers;

import com.spring.baseproject.annotations.auth.AuthorizationRequired;
import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.customer.models.dtos.NewCustomerDto;
import com.spring.baseproject.modules.customer.services.CustomerService;
import com.spring.baseproject.swagger.auth.authentication.CustomerDtoSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AuthorizationRequired
@RequestMapping("/api/auth/customers")
@Api(description = "Thông tin tài khoản khách hàng")
public class CustomerController extends BaseRESTController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "Lấy thông tin tài khoản",
            notes = "Trả về toàn bộ các thông tin tài khoản của người dùng, " +
                    "thực hiện xác thực người dùng bằng access token",
            response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = CustomerDtoSwagger.class),
            @Response(responseValue = ResponseValue.CUSTOMER_NOT_FOUND)
    })
    @GetMapping("/info")
    public BaseResponse getCustomerProfile() {
        getAuthorizedUser().getUserID();
        return customerService.getCustomerDto(getAuthorizedUser().getUserID());
    }

    @ApiOperation(value = "Cập nhật thông tin tài khoản", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.CUSTOMER_NOT_FOUND)
    })
    @AuthorizationRequired
    @PutMapping("/info/{id}")
    public BaseResponse updateProfileCustomer(@PathVariable("id") String customerId,
                                              @RequestBody @Valid NewCustomerDto newCustomerDto) {
        return customerService.updateProfileCustomer(customerId, newCustomerDto);
    }
}
