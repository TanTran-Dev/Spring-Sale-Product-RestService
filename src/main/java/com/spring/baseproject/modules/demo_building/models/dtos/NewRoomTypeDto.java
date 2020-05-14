package com.spring.baseproject.modules.demo_building.models.dtos;

import io.swagger.annotations.ApiModelProperty;

public class NewRoomTypeDto {
    @ApiModelProperty(notes = "id loại phòng")
    private String id;

    public NewRoomTypeDto(String id) {
        this.id = id;
    }

    public NewRoomTypeDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
