package com.example.onlinemarketplace.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category implements Serializable {

    @Id
    @GeneratedValue(generator = "Cat_Gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Cat_Gen", sequenceName = "Cat_Gen")
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_description")
    private String description;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
    private Set<Category> childCategories = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    // Timestamps
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @UpdateTimestamp
    private LocalDateTime lastModifiedAt;
}
