package com.vssoftdev.banking_demo_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")



public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public User() {
    }

    public User(String password, Date dateOfBirth, String name) {
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    private String name;
    private Date dateOfBirth;
    private String password;

}
