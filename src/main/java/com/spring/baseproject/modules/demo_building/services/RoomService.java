package com.spring.baseproject.modules.demo_building.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.demo_building.models.dtos.NewRoomDto;
import com.spring.baseproject.modules.demo_building.models.dtos.RoomDto;
import com.spring.baseproject.modules.demo_building.models.dtos.RoomPreviewDto;
import com.spring.baseproject.modules.demo_building.models.entities.Building;
import com.spring.baseproject.modules.demo_building.models.entities.Room;
import com.spring.baseproject.modules.demo_building.repositories.BuildingRepository;
import com.spring.baseproject.modules.demo_building.repositories.RoomRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    public BaseResponse createNewRoom(NewRoomDto newRoomDto){
        Building building = buildingRepository.findFirstById(newRoomDto.getBuildingID());
        if (building == null){
            return new BaseResponse(ResponseValue.BUILDING_NOT_FOUND);
        }
        Room room = new Room(building, newRoomDto);
        roomRepository.save(room);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getPageRoomDtos(List<String> sortBy, List<String> sortType,
                                     int pageIndex, int pageSize){
        Pageable pageable = SortAndPageFactory
                .createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<RoomPreviewDto> roomPreviewDtoPage = roomRepository.getPageRoomPreviewDtos(pageable);
        return new BaseResponse(ResponseValue.SUCCESS, roomPreviewDtoPage);
    }

    public BaseResponse getRoomDto(String roomId){
        RoomDto roomDto = roomRepository.getRoomDto(roomId);
        if (roomDto == null){
            return new BaseResponse(ResponseValue.ROOM_NOT_FOUND);
        }

        return new BaseResponse(ResponseValue.SUCCESS, roomDto);
    }

    public BaseResponse updateRoom(String roomId, NewRoomDto newRoomDto){
        Building building = buildingRepository.findFirstById(newRoomDto.getBuildingID());
        if (building == null){
            return new BaseResponse(ResponseValue.BUILDING_NOT_FOUND);
        }

        Room room = roomRepository.findFirstById(roomId);
        if (room == null){
            return new BaseResponse(ResponseValue.ROOM_NOT_FOUND);
        }

        room.update(building, newRoomDto);
        roomRepository.save(room);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse deleteRoom(String roomId){
        try{
            roomRepository.deleteById(roomId);
            return new BaseResponse(ResponseValue.SUCCESS);
        }catch (EmptyResultDataAccessException e) {
            return new BaseResponse(ResponseValue.ROOM_NOT_FOUND);
        }
    }

    public BaseResponse deleteListRooms(Set<String> roomIds){
        roomRepository.deleteAllByIdIn(roomIds);
        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
