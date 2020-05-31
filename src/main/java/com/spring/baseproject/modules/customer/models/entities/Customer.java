package com.spring.baseproject.modules.customer.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.customer.models.dtos.NewCustomerDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDay;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @OneToOne(
            fetch = FetchType.LAZY,// always using LAZY fetching strategy
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id")
    private User user;

    public Customer() {
    }

    public Customer(NewCustomerDto newCustomerDto, User user) {
        update(newCustomerDto);
        this.user = user;
        this.id = user.getId();
    }

    public void update(NewCustomerDto newCustomerDto){
        BeanUtils.copyProperties(newCustomerDto, this);

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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
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
}
