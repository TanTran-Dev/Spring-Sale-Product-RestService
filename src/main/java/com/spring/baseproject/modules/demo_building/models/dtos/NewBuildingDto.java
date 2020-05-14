package com.spring.baseproject.modules.demo_building.models.dtos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class NewBuildingDto {
    @ApiModelProperty(notes = "id toà nhà", example = "NOT_EMPTY")
    @NotEmpty
    private String id;

    @ApiModelProperty(notes = "tên toà nhà", example = "NOT_EMPTY", position = 1)
    @NotEmpty
    private String name;

    public NewBuildingDto() {
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
