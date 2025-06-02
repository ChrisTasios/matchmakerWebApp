package com.talentlink.matchmaker.services;

import com.talentlink.matchmaker.dto.PositionDTO;
import com.talentlink.matchmaker.dto.UsersSkillsDTO;
import com.talentlink.matchmaker.repositories.PositionsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionsService {
    private final PositionsRepository positionsRepository;

    public PositionsService(PositionsRepository positionsRepository) {
        this.positionsRepository = positionsRepository;
    }

    public List<PositionDTO> fetchMatchingPositions (List<UsersSkillsDTO> skills) {
        if (skills.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> skillsList = skills.stream()
                 .map(skill -> skill.getSkill())
                 .collect(Collectors.toList());

         List<Object[]> matchedPositions = positionsRepository.fetchAllMatchingPositions(skillsList);

         if (matchedPositions.isEmpty()) {
             return new ArrayList<>();
         }
        return matchedPositions.stream()
                .map(position -> new PositionDTO(
                (Long) position[0],
                (String) position[1],
                (String) position[2],
                (String) position[3]
        )).collect(Collectors.toList());
    }
}
