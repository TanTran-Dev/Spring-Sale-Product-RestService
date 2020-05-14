package com.spring.baseproject.modules.demo_building.models.dtos;

import io.swagger.annotations.ApiModelProperty;

public class RoomTypeDto {
    @ApiModelProperty(notes = "id của loại phòng")
    private String id;

    public RoomTypeDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
