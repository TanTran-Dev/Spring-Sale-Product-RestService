package com.spring.baseproject.modules.demo_building.models.dtos;

import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import com.spring.baseproject.modules.demo_building.models.entities.RoomType;
import io.swagger.annotations.ApiModelProperty;


public class NewRoomDto {
    @ApiModelProperty(notes = "tên phòng", position = 1)
    private String roomName;

    @ApiModelProperty(notes = "Loại phòng", example = "NOT_EMPTY", position = 2)
    private RoomType roomType;

    @ApiModelProperty(notes = "Id của toàn nhà", position = 3)
    private String buildingID;

    @ApiModelProperty(notes = "vị trí phòng tại tầng bao nhiêu?", position = 4)
    private int floor;

    @ApiModelProperty(notes = "Phòng dành cho đối tượng nào?", example = "NOT_EMPTY, VALUE_IN(MALE, FEMALE)", position = 5)
    private Gender gender;

    @ApiModelProperty(notes = "Phòng dành cho bao nhiêu người ?", position = 6)
    private int capacity;

    @ApiModelProperty(notes = "Phòng hiện tại có mấy người?", position = 7)
    private int currentCapacity;

    public NewRoomDto() {
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
}
