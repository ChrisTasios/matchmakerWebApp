package com.talentlink.matchmaker.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "positions")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PositionsReqEntity> requiredSkills;
}
