package com.bright.userprofilems.service.impl;

import com.bright.userprofilems.dto.request.UserRequestDto;
import com.bright.userprofilems.dto.response.UserResponseDto;
import com.bright.userprofilems.exception.ApiError;
import com.bright.userprofilems.exception.user.DuplicateUserException;
import com.bright.userprofilems.exception.user.UserNotFoundException;
import com.bright.userprofilems.mapper.UserMapper;
import com.bright.userprofilems.model.User;
import com.bright.userprofilems.repository.UserRepository;
import com.bright.userprofilems.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        //Check whether user is existing or not
        Optional<User> optionalUser = userRepository.findByUsername(userRequestDto.username());
        if (optionalUser.isPresent()) {
            throw new DuplicateUserException("Username already exists");
        }
        System.out.println("dto: " + userRequestDto);
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        User savedUser = userRepository.save(user);
        System.out.println("saved user: " + userMapper.userToUserResponseDto(savedUser));
        return userMapper.userToUserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto updateUser(String username, UserRequestDto userRequestDto) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            User mappedUser = userMapper.userRequestDtoToUser(userRequestDto);
            mappedUser.setId(existingUser.getId());
            if (mappedUser.getProfile() != null) {
                mappedUser.getProfile().setId(existingUser.getProfile().getId());
            }
            User updatedUser = userRepository.save(mappedUser);
            return userMapper.userToUserResponseDto(updatedUser);
        }
        throw new UserNotFoundException(username + " is not found");
    }

    // Use @Transactional when this call doesn't support by JPA
    @Transactional
    @Override
    public void deleteUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            userRepository.deleteByUsername(username);
        } else {
            throw new UserNotFoundException(username + " is not found");
        }
    }

    @Override
    public UserResponseDto findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.userToUserResponseDto(users);
    }
}

