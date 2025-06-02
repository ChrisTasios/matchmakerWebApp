package com.talentlink.matchmaker.repositories;

import com.talentlink.matchmaker.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM users WHERE email = ?1 AND password = ?2", nativeQuery = true)
    Optional<UserEntity> findByCredentials(String email, String password);

    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);
}
