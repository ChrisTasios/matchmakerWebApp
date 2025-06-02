package com.talentlink.matchmaker.api;

import com.talentlink.matchmaker.dto.LoginRequest;
import com.talentlink.matchmaker.dto.PositionDTO;
import com.talentlink.matchmaker.dto.UsersSkillsDTO;
import com.talentlink.matchmaker.dto.UserDTO;
import com.talentlink.matchmaker.entities.UserEntity;
import com.talentlink.matchmaker.services.PositionsService;
import com.talentlink.matchmaker.services.SkillsService;
import com.talentlink.matchmaker.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class TalentMatchApi {
    private final UsersService usersService;
    private final SkillsService skillsService;
    private final PositionsService positionsService;

    public TalentMatchApi(UsersService usersService, SkillsService skillsService, PositionsService positionsService) {
        this.usersService = usersService;
        this.skillsService = skillsService;
        this.positionsService = positionsService;
    }

    @PostMapping("/users/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginRequest loginRequest) {
        UserEntity userEntity = usersService.findUserWithCredentials(loginRequest.getEmail(), loginRequest.getPassword());
        UserDTO dto = new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
        return ResponseEntity.ok(dto);

    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO user) {
        UserEntity userEntity = usersService.createNewUser(user);
        return ResponseEntity.created(URI.create("/profile/" + userEntity.getId())).build();
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<List<UsersSkillsDTO>> fetchUsersSkills(@PathVariable Long id) {
        List<UsersSkillsDTO> skills = skillsService.fetchAllUsersSkills(id);
        return ResponseEntity.ok(skills);
    }

    @PostMapping("/skills")
    public ResponseEntity<Void> insertSkills(@RequestBody List<UsersSkillsDTO> skill) {
        skillsService.insertSkills(skill);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/skills")
    public ResponseEntity<Void> deleteSkill(@RequestBody UsersSkillsDTO skill) {
        skillsService.deleteSkill(skill);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/proposedPositions")
    public ResponseEntity<List<PositionDTO>> fetchAllMatchingPositions(@RequestBody List<UsersSkillsDTO> usersSkillsDTOS){
        List<PositionDTO> positionDTOS = positionsService.fetchMatchingPositions(usersSkillsDTOS);
        return ResponseEntity.ok(positionDTOS);
    }
}
