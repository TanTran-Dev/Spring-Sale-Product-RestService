package com.spring.baseproject.modules.demo_building.repositories;

import com.spring.baseproject.modules.demo_building.models.dtos.BuildingDto;
import com.spring.baseproject.modules.demo_building.models.entities.Building;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface BuildingRepository extends JpaRepository<Building, String> {
    Building findFirstById(String id);

    @Query("select new com.spring.baseproject.modules.demo_building.models.dtos.BuildingDto(building.id, building.name) " +
            "from Building building")
    List<BuildingDto> getListBuildingDtos(Sort sort);

    @Query("select new com.spring.baseproject.modules.demo_building.models.dtos.BuildingDto(building.id, building.name) " +
            "from Building building " +
            "where building.id = ?1")
    BuildingDto getBuildingDto(String id);

    @Modifying
    @Transactional
    void deleteById(String id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<String> ids);
}
