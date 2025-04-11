package com.bright.userprofilems.service;

import com.bright.userprofilems.dto.request.UserRequestDto;
import com.bright.userprofilems.dto.response.UserResponseDto;
import com.bright.userprofilems.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserResponseDto> createUser(UserRequestDto userRequestDto);
    Optional<UserResponseDto> updateUser(String username, UserRequestDto userRequestDto);
    void deleteUserByUsername(String username);
    Optional<UserResponseDto> findUserByUsername(String username);
    List<UserResponseDto> findAllUsers();
}
//Perform all CRUD operations
