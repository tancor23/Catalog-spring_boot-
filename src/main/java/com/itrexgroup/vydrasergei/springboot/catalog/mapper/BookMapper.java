package com.itrexgroup.vydrasergei.springboot.catalog.mapper;

import com.itrexgroup.vydrasergei.springboot.catalog.dto.BookDto;
import com.itrexgroup.vydrasergei.springboot.catalog.dto.SimpleUserDto;
import com.itrexgroup.vydrasergei.springboot.catalog.domain.BookEntity;
import com.itrexgroup.vydrasergei.springboot.catalog.domain.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper implements AbstractMapper<BookDto, BookEntity> {

    @Override
    public BookDto mapToDto(BookEntity entity) {
        List<UserEntity> userEntityList = entity.getUsers();
        List<SimpleUserDto> simpleUserDtoList = userEntityList.stream().map(this::mapToSimpleUserDto).collect(Collectors.toList());
        return BookDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .author(entity.getAuthor())
                .page(entity.getPage())
                .simpleUserDtoList(simpleUserDtoList)
                .build();
    }

    private SimpleUserDto mapToSimpleUserDto(UserEntity userEntity) {
        return new SimpleUserDto(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName());
    }

    @Override
    public BookEntity mapToEntity(BookDto dto) {
        List<SimpleUserDto> simpleUserDtoList = dto.getSimpleUserDtoList();
        List<UserEntity> userEntityList = simpleUserDtoList.stream().map(this::mapToUserDto).collect(Collectors.toList());
        return BookEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .author(dto.getAuthor())
                .page(dto.getPage())
                .users(userEntityList)
                .build();
    }

    private UserEntity mapToUserDto(SimpleUserDto simpleUserDto) {
        return new UserEntity(simpleUserDto.getId(), simpleUserDto.getFirstName(), simpleUserDto.getLastName());
    }

}
