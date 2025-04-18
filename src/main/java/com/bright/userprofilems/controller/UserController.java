package com.bright.userprofilems.controller;

import com.bright.userprofilems.dto.request.UserRequestDto;
import com.bright.userprofilems.dto.response.UserResponseDto;
import com.bright.userprofilems.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //create a user
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto); //201
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> userResponseDtos = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtos); //200
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserResponseDto> updateUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.updateUser(userRequestDto.username(), userRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto); //200
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //204
    }
}
