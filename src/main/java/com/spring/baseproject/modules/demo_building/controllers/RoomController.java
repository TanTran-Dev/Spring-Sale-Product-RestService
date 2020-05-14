package com.spring.baseproject.modules.demo_building.controllers;

import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.demo_building.models.dtos.NewRoomDto;
import com.spring.baseproject.modules.demo_building.services.RoomService;
import com.spring.baseproject.swagger.demo_building.room_controller.PageRoomPreviewDtosSwagger;
import com.spring.baseproject.swagger.demo_building.room_controller.RoomDtoSwagger;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/room-demo")
public class RoomController extends BaseRESTController {
    @Autowired
    private RoomService roomService;

    @ApiOperation(value = "Tạo mới một phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @PostMapping("/rooms")
    public BaseResponse addRoom(@RequestBody @Valid NewRoomDto newRoomDto) {
        return roomService.createNewRoom(newRoomDto);
    }

    @ApiOperation(value = "Xem danh sách các phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = PageRoomPreviewDtosSwagger.class)
    })
    @GetMapping("/rooms")
    public BaseResponse getPageRoomPreviews(
            @RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
            @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
            @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
            @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return roomService.getPageRoomDtos(sortBy, sortType, pageIndex, pageSize);
    }

    @ApiOperation(value = "Xem chi tiết phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = RoomDtoSwagger.class),
            @Response(responseValue = ResponseValue.ROOM_NOT_FOUND)
    })
    @GetMapping("/rooms/{rId}")
    public BaseResponse getRoom(@PathVariable("rId") String roomId){
        return roomService.getRoomDto(roomId);
    }

    @ApiOperation(value = "Cập nhật thông tin phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS,responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.ROOM_NOT_FOUND)
    })
    @PutMapping("/rooms/{rId}")
    public BaseResponse updateRoom(@PathVariable("rId") String roomId,
                                   @RequestBody @Valid NewRoomDto newRoomDto){
        return roomService.updateRoom(roomId, newRoomDto);
    }

    @ApiOperation(value = "Xóa một phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.ROOM_NOT_FOUND)
    })
    @DeleteMapping("/rooms/{rId}")
    public BaseResponse deleteRoom(@PathVariable("rId") String roomId){
        return roomService.deleteRoom(roomId);
    }

    @ApiOperation(value = "Xóa một danh sách phòng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @DeleteMapping("/rooms")
    public BaseResponse deleteListRooms(@RequestBody Set<String> roomIds){
        return roomService.deleteListRooms(roomIds);
    }
}
