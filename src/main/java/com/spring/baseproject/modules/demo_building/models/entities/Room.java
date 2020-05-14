package com.spring.baseproject.modules.demo_building.models.entities;

import com.spring.baseproject.modules.demo_building.models.dtos.NewRoomDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", length = 36)
    private String id;

    @OneToOne(
            fetch = FetchType.LAZY,// always using LAZY fetching strategy
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "roomType")
    private RoomType roomType;

    @OneToOne(
            fetch = FetchType.LAZY,// always using LAZY fetching strategy
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "buildingID")
    private Building building;

    @Column(name = "floor")
    private int floor;

    @Column(name = "name")
    private String roomName;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "currentCapacity")
    private int currentCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "createdDate")
    private Date createdDate;

    public Room() {
    }

    public Room(Building building, NewRoomDto newRoomDto) {
        update(building, newRoomDto);
        this.createdDate = new Date();
    }

    public void update(Building building, NewRoomDto newRoomDto){
        this.building = building;
        this.roomType = newRoomDto.getRoomType();
        this.floor = newRoomDto.getFloor();
        this.roomName = newRoomDto.getRoomName();
        this.capacity = newRoomDto.getCapacity();
        this.currentCapacity = newRoomDto.getCurrentCapacity();
        this.gender = newRoomDto.getGender();
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
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
