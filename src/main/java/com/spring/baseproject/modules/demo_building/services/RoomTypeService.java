package com.spring.baseproject.modules.demo_building.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.demo_building.models.dtos.NewRoomTypeDto;
import com.spring.baseproject.modules.demo_building.models.dtos.RoomTypeDto;
import com.spring.baseproject.modules.demo_building.models.entities.RoomType;
import com.spring.baseproject.modules.demo_building.repositories.RoomTypeRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public BaseResponse createRoomTypeDto(NewRoomTypeDto newRoomTypeDto){
        RoomType roomType = new RoomType(newRoomTypeDto);
        roomTypeRepository.save(roomType);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getListRoomTypeDtos(List<String> sortBy, List<String> sortType){
        Sort sort = SortAndPageFactory.createSort(sortBy, sortType);
        List<RoomTypeDto> roomTypeDtos = roomTypeRepository.getListRoomTypeDtos(sort);
        return new BaseResponse(ResponseValue.SUCCESS, roomTypeDtos);
    }

    public BaseResponse getRoomTypeDto(String roomTypeId){
        RoomTypeDto roomTypeDto = roomTypeRepository.getRoomTypeDto(roomTypeId);
        if (roomTypeDto == null){
            return new BaseResponse(ResponseValue.ROOM_TYPE_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, roomTypeDto);
    }
}
