package com.talentlink.matchmaker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "positions_skills")
public class PositionsReqEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;
}
