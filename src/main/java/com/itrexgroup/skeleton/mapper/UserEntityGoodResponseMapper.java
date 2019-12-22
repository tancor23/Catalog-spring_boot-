package com.itrexgroup.skeleton.mapper;

import com.itrexgroup.skeleton.dto.UserShortResponseDto;
import com.itrexgroup.skeleton.entity.UserEntity;

public class UserEntityGoodResponseMapper implements AbstractMapper<UserShortResponseDto, UserEntity> {

    @Override
    public UserShortResponseDto mapToDto(UserEntity entity) {
        return UserShortResponseDto.builder()
                .id(entity.getId())
                .login(entity.getLogin())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .role(entity.getRole())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public UserEntity mapToEntity(UserShortResponseDto dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .login(dto.getLogin())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .role(dto.getRole())
                .status(dto.getStatus())
                .build();
    }
}
