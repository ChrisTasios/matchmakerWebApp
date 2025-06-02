package com.talentlink.matchmaker.repositories;

import com.talentlink.matchmaker.dto.PositionDTO;
import com.talentlink.matchmaker.entities.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionsRepository extends JpaRepository<PositionEntity, Long> {

    @Query(value = """
    SELECT p.id, p.title, p.description, c.name 
    FROM positions p
    JOIN companies c ON p.company_id = c.id
    JOIN positions_skills ps ON p.id = ps.position_id
    WHERE ps.name IN (?1)
    """, nativeQuery = true)
    List<Object[]> fetchAllMatchingPositions(List<String> skills);

}
