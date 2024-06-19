package org.example.doanki2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "username",  unique = true, length = 50)
    private String username;

    @Column(name = "password",  length = 50)
    private String password;

    @Column(name = "email", unique = true, length = 50)
    private String email;

    @Column( columnDefinition = "ENUM('admin', 'customer', 'staff') DEFAULT 'customer'")
    private String role = "customer";

    @Column(name = "created_at")
    private Timestamp created_at;
}
