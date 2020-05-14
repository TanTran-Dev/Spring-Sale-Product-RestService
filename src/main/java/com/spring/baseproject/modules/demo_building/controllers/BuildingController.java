package com.spring.baseproject.modules.demo_building.controllers;

import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.demo_building.models.dtos.NewBuildingDto;
import com.spring.baseproject.modules.demo_building.services.BuildingService;
import com.spring.baseproject.swagger.demo_building.building_controller.BuildingDtoSwagger;
import com.spring.baseproject.swagger.demo_building.building_controller.ListBuildingDtosSwagger;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/building-demo")
public class BuildingController extends BaseRESTController {
    @Autowired
    private BuildingService buildingService;

    @ApiOperation(value = "Tạo mới một toà nhà", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @PostMapping("/buildings")
    public BaseResponse addBuilding(@RequestBody @Valid NewBuildingDto newBuildingDto) {
        return buildingService.createNewBuildingDto(newBuildingDto);
    }


    @ApiOperation(value = "Lấy danh sách các toà nhà", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ListBuildingDtosSwagger.class)
    })
    @GetMapping("/buildings")
    public BaseResponse getBuildings(@RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
                                     @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType) {
        return buildingService.getListBuildingDtos(sortBy, sortType);
    }

    @ApiOperation(value = "Xem thông tin toà nhà", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BuildingDtoSwagger.class),
            @Response(responseValue = ResponseValue.BUILDING_NOT_FOUND)
    })
    @GetMapping("/buildings/{bId}")
    public BaseResponse getBuilding(@PathVariable("bId") String buildingId){
        return buildingService.getBuildingDto(buildingId);
    }


    @ApiOperation(value = "Cập nhật thông tin toà ", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.BUILDING_NOT_FOUND)
    })
    @PutMapping("/buildings/{bId}")
    public BaseResponse updateBuilding(@PathVariable("bId") String buildingId,
                                       @RequestBody @Valid NewBuildingDto newBuildingDto){
        return buildingService.updateBuildingDto(buildingId, newBuildingDto);
    }

    @ApiOperation(value = "Xóa một toà nhà", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.BUILDING_NOT_FOUND)
    })
    @DeleteMapping("/buildings/{bId}")
    public BaseResponse deleteBuilding(@PathVariable("bId") String buildingId){
        return buildingService.deleteBuildingDto(buildingId);
    }

    @ApiOperation(value = "Xóa một danh sách toà nhà", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @DeleteMapping("/buildings")
    public BaseResponse deleteListBuilding(@RequestBody Set<String> buildingsId){
        return buildingService.deleteListBuildingDtos(buildingsId);
    }
}
