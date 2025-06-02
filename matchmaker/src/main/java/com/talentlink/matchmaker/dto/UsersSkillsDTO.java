package com.talentlink.matchmaker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersSkillsDTO {
    public UsersSkillsDTO(Long skillId, Long userId, String skill) {
        this.skillId = skillId;
        this.userId = userId;
        this.skill = skill;
    }

    private Long skillId;
    private Long userId;
    private String skill;

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

}
