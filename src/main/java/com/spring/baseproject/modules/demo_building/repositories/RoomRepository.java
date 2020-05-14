package com.spring.baseproject.modules.demo_building.repositories;

import com.spring.baseproject.modules.demo_building.models.dtos.RoomDto;
import com.spring.baseproject.modules.demo_building.models.dtos.RoomPreviewDto;
import com.spring.baseproject.modules.demo_building.models.entities.Building;
import com.spring.baseproject.modules.demo_building.models.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, String> {
    @Query("select new com.spring.baseproject" +
            ".modules.demo_building.models.dtos.RoomPreviewDto(" +
            "room.id, room.roomType, building.id, building.name, room.roomName, room.createdDate, room.gender) " +
            "from Room room " +
            "left join room.building building")
    Page<RoomPreviewDto> getPageRoomPreviewDtos(Pageable pageable);

    @Query("select new com.spring.baseproject" +
            ".modules.demo_building.models.dtos.RoomDto(room.id, roomType.id, building.id, building.name, room.floor, " +
            "room.roomName, room.capacity, room.currentCapacity, room.gender, room.createdDate) " +
            "from Room room " +
            "left join room.building building " +
            "left join room.roomType roomType " +
            "where room.id = ?1")
    RoomDto getRoomDto(String roomId);

    Room findFirstById(String id);


    @Modifying
    @Transactional
    void deleteById(String id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<String> ids);
}
