package com.itrexgroup.skeleton.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrexgroup.skeleton.domain.UserEntity;
import com.itrexgroup.skeleton.dto.UserDto;
import com.itrexgroup.skeleton.exception.NotFoundException;
import com.itrexgroup.skeleton.mapper.AbstractMapper;
import com.itrexgroup.skeleton.mapper.UserMapper;
import com.itrexgroup.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "user", produces = "application/json;charset=UTF-8")
public class UserController {

    private final UserService userService;
    private final AbstractMapper<UserDto, UserEntity> userMapper = new UserMapper();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> list() {
        List<UserEntity> userEntities = userService.getAllUserEntity();
        return userMapper.mapAllToDto(userEntities);
    }

    @GetMapping("{id}")
    public UserDto readById(@PathVariable(value = "id") Long userId) {
        UserEntity userEntity = userService.readById(userId);
        return userMapper.mapToDto(userEntity);
    }

    @PostMapping
    public List<UserDto> create(@RequestBody String userData) {
        try {
            UserDto userDto = objectMapper.readValue(userData, UserDto.class);
            UserEntity userEntity = userMapper.mapToEntity(userDto);
            userService.create(userEntity);
        } catch (JsonProcessingException e) {
            throw new NotFoundException();
        }
        return list();
    }

    @PutMapping("{id}")
    public UserDto update(@PathVariable(value = "id") Long userId,
                          @Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.mapToEntity(userDto);
        userEntity.setId(userId);
        userService.update(userEntity);
        return userMapper.mapToDto(userEntity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value = "id") Long userId) {
        userService.delete(userService.readById(userId));
    }
}

