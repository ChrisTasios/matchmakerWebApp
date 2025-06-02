package com.talentlink.matchmaker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class UsersSkillsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public String getSkillName() {
        return skillName;
    }

    public UsersSkillsEntity setSkillName(String skillName) {
        this.skillName = skillName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UsersSkillsEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public UsersSkillsEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    @Column
    private String skillName;

}
