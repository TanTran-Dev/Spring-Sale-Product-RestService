package com.spring.baseproject.modules.demo_building.models.dtos;

import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class RoomDto {
    @ApiModelProperty(notes = "id phòng")
    private String id;

    @ApiModelProperty(notes = "loại phòng", position = 1)
    private String roomType;

    @ApiModelProperty(notes = "toà nhà ", position = 2)
    private BuildingDto building;

    @ApiModelProperty(notes = "số tầng", position = 3)
    private int floor;

    @ApiModelProperty(notes = "tên phòng", position = 4)
    private String roomName;

    @ApiModelProperty(notes = "sức chứa của phòng", position = 5)
    private int capacity;

    @ApiModelProperty(notes = "sức chứa hiện tại", position = 6)
    private int currentCapacity;

    @ApiModelProperty(notes = "loại phòng dành cho ??", position = 7)
    private Gender gender;

    @ApiModelProperty(notes = "ngày lập phòng", position = 8)
    private Date createdDate;

    public RoomDto() {
    }

    public RoomDto(String id, String roomType, String buildingID, String buildingName,
                   int floor, String roomName, int capacity, int currentCapacity,
                   Gender gender, Date createdDate) {
        this.id = id;
        this.roomType = roomType;
        this.building = new BuildingDto(buildingID, buildingName);
        this.floor = floor;
        this.roomName = roomName;
        this.capacity = capacity;
        this.currentCapacity = currentCapacity;
        this.gender = gender;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BuildingDto getBuilding() {
        return building;
    }

    public void setBuilding(BuildingDto building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
