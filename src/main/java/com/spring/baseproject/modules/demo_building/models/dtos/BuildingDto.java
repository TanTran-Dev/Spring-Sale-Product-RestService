package com.spring.baseproject.modules.demo_building.models.dtos;

import io.swagger.annotations.ApiModelProperty;

public class BuildingDto {
    @ApiModelProperty(notes = "id của toà nhà")
    private String id;

    @ApiModelProperty(notes = "tên của toà nhà", position = 1)
    private String name;

    public BuildingDto() {
    }

    public BuildingDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
