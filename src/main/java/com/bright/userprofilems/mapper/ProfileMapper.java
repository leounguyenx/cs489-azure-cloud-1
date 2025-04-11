package com.bright.userprofilems.mapper;

import com.bright.userprofilems.dto.request.ProfileRequestDto;
import com.bright.userprofilems.dto.response.ProfileResponseDto;
import com.bright.userprofilems.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    Profile profileRequestDtoToProfile(ProfileRequestDto profileRequestDto);

    ProfileResponseDto profileToProfileResponseDto(Profile profile);
}
//No explicit mapping is required here
