package com.spring.baseproject.modules.demo_building.repositories;

import com.spring.baseproject.modules.demo_building.models.dtos.RoomTypeDto;
import com.spring.baseproject.modules.demo_building.models.entities.RoomType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, String> {
    RoomType findFirstById(String id);

    @Query("select new com.spring.baseproject.modules.demo_building.models.dtos.RoomTypeDto(roomType.id) " +
            "from RoomType roomType")
    List<RoomTypeDto> getListRoomTypeDtos(Sort sort);

    @Query("select new com.spring.baseproject.modules.demo_building.models.dtos.RoomTypeDto(roomType.id) " +
            "from RoomType roomType " +
            "where roomType.id = ?1")
    RoomTypeDto getRoomTypeDto(String id);
}
