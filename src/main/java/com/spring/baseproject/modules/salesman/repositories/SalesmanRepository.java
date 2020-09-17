package com.spring.baseproject.modules.salesman.repositories;

import com.spring.baseproject.modules.salesman.models.dtos.SalesmanDto;
import com.spring.baseproject.modules.salesman.models.entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalesmanRepository extends JpaRepository<Salesman, String> {
    Salesman findFirstById(String id);

    boolean existsByUser_Username(String username);

    @Query("select new com.spring.baseproject.modules.salesman.models.dtos.SalesmanDto" +
            "(s.id, s.firstName, s.lastName, s.address, s.birthDay, s.phone, s.contactEmail, s.gender, s.avatarUrl, s.imageCoverUrl) " +
            "from Salesman s " +
            "left join s.user u " +
            "where s.id = ?1")
    SalesmanDto getSalesmanDto(String salesmanId);
}
