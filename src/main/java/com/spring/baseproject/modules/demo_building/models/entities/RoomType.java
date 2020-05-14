package com.spring.baseproject.modules.demo_building.models.entities;

import com.spring.baseproject.modules.demo_building.models.dtos.NewRoomTypeDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_type")
public class RoomType {
    @Id
    @Column(name = "id")
    private String id;

    public RoomType() {
    }

    public RoomType(NewRoomTypeDto newRoomTypeDto) {
        this.id = newRoomTypeDto.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
