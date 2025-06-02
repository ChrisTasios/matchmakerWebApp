package com.talentlink.matchmaker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PositionDTO {
    private Long id;
    private String name;
    private String description;
    private String Company;

    public PositionDTO(Long id, String name, String description, String company) {
        this.id = id;
        this.name = name;
        this.description = description;
        Company = company;
    }

    public Long getId() {
        return id;
    }

    public PositionDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PositionDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PositionDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCompany() {
        return Company;
    }

    public PositionDTO setCompany(String company) {
        Company = company;
        return this;
    }
}
