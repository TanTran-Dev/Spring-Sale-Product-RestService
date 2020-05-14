package com.spring.baseproject.modules.demo_building.models.entities;

import com.spring.baseproject.modules.demo_building.models.dtos.NewBuildingDto;

import javax.persistence.*;


@Entity
@Table(name = "building")
public class Building {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    public Building() {
    }

    public Building(NewBuildingDto newBuildingDto){
        update(newBuildingDto);
    }

    public String getId() {
        return id;
    }

    public void update(NewBuildingDto newBuildingDto){
        this.id = newBuildingDto.getId();
        this.name = newBuildingDto.getName();
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
