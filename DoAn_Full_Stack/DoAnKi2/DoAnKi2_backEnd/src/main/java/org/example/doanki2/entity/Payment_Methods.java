package org.example.doanki2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment_Methods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_method_id;

    private String method_name;

    private String description;
}
