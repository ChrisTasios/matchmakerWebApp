package com.talentlink.matchmaker.services;

import com.talentlink.matchmaker.dto.UserDTO;
import com.talentlink.matchmaker.entities.UserEntity;
import com.talentlink.matchmaker.exceptions.EntityAlreadyExistsException;
import com.talentlink.matchmaker.exceptions.GenericNotFoundException;
import com.talentlink.matchmaker.exceptions.InvalidCredentialsException;
import com.talentlink.matchmaker.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserEntity findUserWithCredentials(String email, String password) {
        if (usersRepository.findByEmail(email).isPresent()) {
            return usersRepository.findByCredentials(email, password)
                    .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));
        }
        throw new GenericNotFoundException("Customer with email '" + email + "' was not found");
    }

    public UserEntity createNewUser(UserDTO userDTO) {
        if (usersRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new EntityAlreadyExistsException("Customer already exists");
        }

        return usersRepository.save(new UserEntity()
                .setEmail(userDTO.getEmail())
                .setName(userDTO.getName())
                .setPassword(userDTO.getPassword()));
    }
}
