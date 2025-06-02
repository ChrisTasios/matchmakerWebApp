package com.talentlink.matchmaker.repositories;

import com.talentlink.matchmaker.entities.UsersSkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsRepository extends JpaRepository<UsersSkillsEntity, Long> {
    @Query(value = "SELECT * FROM skills WHERE user_id = ?1", nativeQuery = true)
    List<UsersSkillsEntity> findByUserId(Long id);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END" +
            " FROM skills WHERE user_id = ?2 AND skill_name = ?1", nativeQuery = true)
    boolean skillExistsForUserWithId(String skillName, Long id);
}
