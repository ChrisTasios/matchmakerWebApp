package com.talentlink.matchmaker.services;

import com.talentlink.matchmaker.dto.UsersSkillsDTO;
import com.talentlink.matchmaker.entities.UsersSkillsEntity;
import com.talentlink.matchmaker.entities.UserEntity;
import com.talentlink.matchmaker.exceptions.GenericNotFoundException;
import com.talentlink.matchmaker.repositories.SkillsRepository;
import com.talentlink.matchmaker.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillsService {
    private final SkillsRepository skillsRepository;
    private final UsersRepository usersRepository;

    public SkillsService(SkillsRepository skillsRepository, UsersRepository usersRepository) {
        this.skillsRepository = skillsRepository;
        this.usersRepository = usersRepository;
    }

    public List<UsersSkillsDTO> fetchAllUsersSkills(Long id) {
        usersRepository.findById(id).orElseThrow(() -> new GenericNotFoundException("Customer not found"));
        List<UsersSkillsEntity> skillsEntities = skillsRepository.findByUserId(id);
        return skillsEntities.stream()
                .map(skill -> new UsersSkillsDTO(
                        skill.getId(),
                        skill.getUserEntity().getId(),
                        skill.getSkillName()))
                .collect(Collectors.toList());
    }

    public void insertSkills(List<UsersSkillsDTO> skills) {
        UserEntity userEntity = usersRepository.findById(skills.get(0).getUserId()).orElseThrow(() -> new GenericNotFoundException("Customer not found"));
        for (UsersSkillsDTO skill : skills) {
            if (skillsRepository.skillExistsForUserWithId(skill.getSkill(), skill.getUserId())) {
                continue;
            }
            skillsRepository.save(new UsersSkillsEntity()
                    .setSkillName(skill.getSkill().toLowerCase())
                    .setUserEntity(userEntity));
        }
    }

    public void deleteSkill(UsersSkillsDTO skill) {
        usersRepository.findById(skill.getUserId()).orElseThrow(() -> new GenericNotFoundException("Customer not found"));
        UsersSkillsEntity skillsEntity = skillsRepository.findById(skill.getSkillId()).orElseThrow(() -> new GenericNotFoundException("Skill not found"));
        skillsRepository.delete(skillsEntity);
    }
}
