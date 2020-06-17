package com.spring.baseproject.modules.auth.repositories;

import com.spring.baseproject.modules.auth.models.dtos.UserDto;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.models.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface UserRepository extends JpaRepository<User, String> {
    User findFirstById(String userId);

    @Query("select u from User u " +
            "where u.username = ?1")
    User getUserFetch(String username);

    @Modifying
    @Transactional
    @Query("update User u set u.lastActive = ?2 where u.id = ?1")
    void updateLastActive(String userID, Date lastActive);

    boolean existsByUsername(String username);

    @Query("select u.isBanned from User u where u.id = ?1")
    boolean isUserBanned(String userID);

    @Query("select new com.spring.baseproject.modules.auth.models.dtos.UserDto" +
            "(u.id, u.username, u.userType, u.isBanned, u.lastActive) " +
            "from User u " +
            "where u.id = ?1")
    UserDto getUserDto(String userID, Date createdDate);

    @Query("select u.userType from User u " +
            "where u.id = ?1")
    UserType getUserType(String userID);
}
