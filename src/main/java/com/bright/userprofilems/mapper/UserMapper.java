package com.bright.userprofilems.mapper;

import com.bright.userprofilems.dto.request.UserRequestDto;
import com.bright.userprofilems.dto.response.UserResponseDto;
import com.bright.userprofilems.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ProfileMapper.class)
public interface UserMapper {

    @Mapping(source = "profileRequestDto", target = "profile")
    User userRequestDtoToUser(UserRequestDto userRequestDto);

    @Mapping(source = "profile", target = "profileResponseDto")
    UserResponseDto userToUserResponseDto(User user);

    @Mapping(source = "profile", target = "profileResponseDto")
    List<UserResponseDto> userToUserResponseDto(List<User> user);
}
