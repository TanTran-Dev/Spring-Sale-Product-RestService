package com.spring.baseproject.modules.customer.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.customer.models.dtos.NewCustomerDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birthDay;

    @Column(name = "phone")
    private String phone;

    @Column(name = "contact_email")
    private String contactEmail;

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

    public Customer(NewCustomerDto newCustomerDto, User user) {
        update(newCustomerDto);
        this.user = user;
        this.id = user.getId();
    }

    public void update(NewCustomerDto newCustomerDto){
        BeanUtils.copyProperties(newCustomerDto, this);
    }
}
