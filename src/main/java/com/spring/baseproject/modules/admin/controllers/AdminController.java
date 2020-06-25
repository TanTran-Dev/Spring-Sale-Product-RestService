package com.spring.baseproject.modules.admin.controllers;

import com.spring.baseproject.annotations.auth.AuthorizationRequired;
import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.admin.models.dtos.NewAdminDto;
import com.spring.baseproject.modules.admin.services.AdminService;
import com.spring.baseproject.swagger.auth.authentication.AdminDtoSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AuthorizationRequired
@RequestMapping("/api/auth/admins")
@Api(description = "Thông tin tài khoản admin")
public class AdminController extends BaseRESTController {
    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "Lấy thông tin tài khoản",
            notes = "Trả về toàn bộ các thông tin tài khoản của người dùng, " +
                    "thực hiện xác thực người dùng bằng access token",
            response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = AdminDtoSwagger.class),
            @Response(responseValue = ResponseValue.ADMIN_NOT_FOUND)
    })
    @GetMapping("/info")
    public BaseResponse getAdminProfile() {
        getAuthorizedUser().getUserID();
        return adminService.getAdminDto(getAuthorizedUser().getUserID());
    }

    @ApiOperation(value = "Cập nhật thông tin tài khoản", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.ADMIN_NOT_FOUND)
    })
    @AuthorizationRequired
    @PutMapping("/info/{id}")
    public BaseResponse updateProfileAdmin(@PathVariable("id") String adminId,
                                           @RequestBody @Valid NewAdminDto newAdminDto) {
        return adminService.updateAdmin(adminId, newAdminDto);
    }
}
