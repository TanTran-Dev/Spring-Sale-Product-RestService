package com.spring.baseproject.modules.admin.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.admin.models.dtos.NewAdminDto;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.models.entities.UserType;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "birth_day")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birthDay;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "avatar")
    private String avatarUrl;

    @Column(name = "image_cover")
    private String imageCoverUrl;

    @OneToOne(
            fetch = FetchType.LAZY,// always using LAZY fetching strategy
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "user_id")
    private User user;

    public Admin() {
    }

    public Admin(NewAdminDto newAdminDto, User user) {
        update(newAdminDto);
        this.id = user.getId();
        this.user = user;
    }

    public void update(NewAdminDto newAdminDto) {
        BeanUtils.copyProperties(newAdminDto, this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getImageCoverUrl() {
        return imageCoverUrl;
    }

    public void setImageCoverUrl(String imageCoverUrl) {
        this.imageCoverUrl = imageCoverUrl;
    }
}
