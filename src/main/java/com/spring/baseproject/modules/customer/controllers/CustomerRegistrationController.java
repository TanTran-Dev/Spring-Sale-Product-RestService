package com.spring.baseproject.modules.customer.controllers;

import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.customer.models.dtos.NewCustomerDto;
import com.spring.baseproject.modules.customer.services.CustomerRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/customers")
@Api(description = "Tạo tài khoản khách hàng")
public class CustomerRegistrationController extends BaseRESTController {
    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @ApiOperation(value = "Tạo mới một tài khoản người dùng",
            notes = "Tạo mới một tài khoản người dùng, có kiểm tra username tồn tại, " +
                    "mật khẩu người dùng sẽ được hash trước khi persist\n" +
                    "Lưu ý: với mục đích phát triển, mật khẩu sẽ không được hashing (noop)",
            response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.USERNAME_EXISTS)
    })
    @PostMapping()
    public BaseResponse registerNewUserAdmin(@RequestBody @Valid NewCustomerDto newCustomerDto) {
        return customerRegistrationService.registerNewCustomer(newCustomerDto);
    }
}
