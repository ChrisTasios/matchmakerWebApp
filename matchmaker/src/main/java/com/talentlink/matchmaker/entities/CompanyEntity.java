package com.talentlink.matchmaker.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PositionEntity> positions;
}
