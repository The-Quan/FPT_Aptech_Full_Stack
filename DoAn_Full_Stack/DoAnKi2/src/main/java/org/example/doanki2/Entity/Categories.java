package org.example.doanki2.Entity;

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
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    @Column(name = "category_name", nullable = false, length = 50)
    private String category_name;

    @Column(name ="description", nullable = false, columnDefinition = "TEXT")
    private String description;
}
