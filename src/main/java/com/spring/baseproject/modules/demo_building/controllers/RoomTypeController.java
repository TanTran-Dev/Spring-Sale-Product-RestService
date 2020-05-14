package com.spring.baseproject.modules.demo_building.controllers;

import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.demo_building.models.dtos.NewRoomTypeDto;
import com.spring.baseproject.modules.demo_building.services.RoomTypeService;
import com.spring.baseproject.swagger.demo_building.room_type_controller.ListRoomTypeDtoSwagger;
import com.spring.baseproject.swagger.demo_building.room_type_controller.RoomTypeDtoSwagger;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/room-type-demo")
public class RoomTypeController extends BaseRESTController {
    @Autowired
    private RoomTypeService roomTypeService;

    @ApiOperation(value = "Tạo mới một loại phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @PostMapping("/roomTypes")
    public BaseResponse addRoomType(@RequestBody @Valid NewRoomTypeDto newRoomTypeDto){
        return roomTypeService.createRoomTypeDto(newRoomTypeDto);
    }

    @ApiOperation(value = "Lấy danh sách loại phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ListRoomTypeDtoSwagger.class)
    })
    @GetMapping("/roomTypes")
    public BaseResponse getListRoomTypes(@RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false)List<String> sortBy,
                                         @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType){
        return roomTypeService.getListRoomTypeDtos(sortBy, sortType);
    }

    @ApiOperation(value = "Xem chi thông tin loại phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = RoomTypeDtoSwagger.class),
            @Response(responseValue = ResponseValue.PRODUCT_TYPE_NOT_FOUND)
    })
    @GetMapping("/roomType/{rtId}")
    public BaseResponse getRoomType(@PathVariable("rtId") String rtId){
        return roomTypeService.getRoomTypeDto(rtId);
    }
}
