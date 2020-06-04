package com.spring.baseproject.modules.admin.repositories;

import com.spring.baseproject.modules.admin.models.dtos.AdminDto;
import com.spring.baseproject.modules.admin.models.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findFirstById(String id);

    boolean existsByUser_Username(String username);

    @Query("select new com.spring.baseproject.modules.admin.models.dtos.AdminDto" +
            "(a.id, a.firstName, a.lastName, a.address, a.birthDay, a.phone, a.gender," +
            "u.id, u.username, u.isBanned, u.lastActive) " +
            "from Admin a " +
            "left join a.user u " +
            "where a.id = ?1")
    AdminDto getAdminDto(String adminId);
}
