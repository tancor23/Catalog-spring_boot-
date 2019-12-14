package com.itrexgroup.skeleton.mapper;

import com.itrexgroup.skeleton.domain.UserEntity;
import com.itrexgroup.skeleton.dto.UserDto;

public class UserMapper implements AbstractMapper<UserDto, UserEntity> {

    @Override
    public UserDto mapToDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .login(entity.getLogin())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .role(entity.getRole())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    @Override
    public UserEntity mapToEntity(UserDto dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .role(dto.getRole())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
