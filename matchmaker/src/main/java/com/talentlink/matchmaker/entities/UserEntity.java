package com.talentlink.matchmaker.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity", orphanRemoval = true)
    private List<UsersSkillsEntity> skills;


    public Long getId() {

        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<UsersSkillsEntity> getSkills() {
        return skills;
    }

    public UserEntity setSkills(List<UsersSkillsEntity> skills) {
        this.skills = skills;
        return this;
    }
}
