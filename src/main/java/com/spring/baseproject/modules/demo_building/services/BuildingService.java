package com.spring.baseproject.modules.demo_building.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.demo_building.models.dtos.BuildingDto;
import com.spring.baseproject.modules.demo_building.models.dtos.NewBuildingDto;
import com.spring.baseproject.modules.demo_building.models.entities.Building;
import com.spring.baseproject.modules.demo_building.repositories.BuildingRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public BaseResponse createNewBuildingDto(NewBuildingDto newBuildingDto) {
        Building building = new Building(newBuildingDto);
        buildingRepository.save(building);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getListBuildingDtos(List<String> sortBy, List<String> sortType) {
        Sort sort = SortAndPageFactory.createSort(sortBy, sortType);
        List<BuildingDto> buildingDtos = buildingRepository.getListBuildingDtos(sort);
        return new BaseResponse(ResponseValue.SUCCESS, buildingDtos);
    }

    public BaseResponse getBuildingDto(String buildingId) {
        BuildingDto buildingDto = buildingRepository.getBuildingDto(buildingId);
        if (buildingDto == null) {
            return new BaseResponse(ResponseValue.BUILDING_NOT_FOUND);
        }

        return new BaseResponse(ResponseValue.SUCCESS, buildingDto);
    }

    public BaseResponse updateBuildingDto(String buildingId, NewBuildingDto newBuildingDto) {
        Building building = buildingRepository.findFirstById(buildingId);
        if (building == null) {
            return new BaseResponse(ResponseValue.BUILDING_NOT_FOUND);
        }

        building.update(newBuildingDto);
        buildingRepository.save(building);

        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse deleteBuildingDto(String buildingId) {
        try {
            buildingRepository.deleteById(buildingId);
            return new BaseResponse(ResponseValue.SUCCESS);
        } catch (Exception e) {
            return new BaseResponse(ResponseValue.BUILDING_NOT_FOUND);
        }
    }

    public BaseResponse deleteListBuildingDtos(Set<String> buildingId) {
        buildingRepository.deleteAllByIdIn(buildingId);
        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
