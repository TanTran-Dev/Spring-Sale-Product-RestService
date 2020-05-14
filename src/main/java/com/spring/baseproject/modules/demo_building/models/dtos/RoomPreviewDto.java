package com.spring.baseproject.modules.demo_building.models.dtos;

import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import com.spring.baseproject.modules.demo_building.models.entities.RoomType;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class RoomPreviewDto {
    @ApiModelProperty(notes = "id phòng")
    private String id;

    @ApiModelProperty(notes = "loại phòng", position = 1)
    private RoomType roomType;

    @ApiModelProperty(notes = "toà nhà ", position = 2)
    private BuildingDto building;

    @ApiModelProperty(notes = "tên phòng", position = 3)
    private String roomName;

    @ApiModelProperty(notes = "ngày lập phòng", position = 4)
    private Date createdDate;

    public RoomPreviewDto() {
    }

    public RoomPreviewDto(String id, RoomType roomType, String buildingID, String buildingName,
                          String roomName, Date createdDate, Gender gender) {
        this.id = id;
        this.roomType = roomType;
        this.building = new BuildingDto(buildingID, buildingName);
        this.roomName = roomName;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BuildingDto getBuilding() {
        return building;
    }

    public void setBuilding(BuildingDto building) {
        this.building = building;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
