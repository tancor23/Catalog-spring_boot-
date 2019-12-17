package com.itrexgroup.skeleton.controller;

import com.itrexgroup.skeleton.entity.UserEntity;
import com.itrexgroup.skeleton.dto.UserDto;
import com.itrexgroup.skeleton.mapper.AbstractMapper;
import com.itrexgroup.skeleton.mapper.UserMapper;
import com.itrexgroup.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "users", produces = "application/json;charset=UTF-8")
public class UserController {

    private final UserService userService;
    private final AbstractMapper<UserDto, UserEntity> userMapper = new UserMapper();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> list() {
        List<UserEntity> userEntities = userService.getAllUserEntity();
        return userMapper.mapAllToDto(userEntities);
    }

    @GetMapping("/{id}")
    public UserDto readById(@PathVariable(value = "id") Long userId) {
        UserEntity userEntity = userService.readById(userId);
        return userMapper.mapToDto(userEntity);
    }

    @PostMapping
    public UserDto create(@Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.mapToEntity(userDto);
        UserEntity newUserEntity = userService.create(userEntity);
        return userMapper.mapToDto(newUserEntity);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable(value = "id") Long userId, @Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.mapToEntity(userDto);
        userEntity.setId(userId);
        userService.update(userEntity);
        return userMapper.mapToDto(userEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long userId) {
        UserEntity userEntity = userService.readById(userId);
        userService.delete(userEntity);
    }
}

