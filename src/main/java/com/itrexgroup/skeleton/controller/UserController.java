package com.itrexgroup.skeleton.controller;

import com.itrexgroup.skeleton.dto.UserDto;
import com.itrexgroup.skeleton.dto.UserMessageResponseDto;
import com.itrexgroup.skeleton.dto.UserShortResponseDto;
import com.itrexgroup.skeleton.entity.UserEntity;
import com.itrexgroup.skeleton.mapper.AbstractMapper;
import com.itrexgroup.skeleton.mapper.UserEntityDtoMapper;
import com.itrexgroup.skeleton.mapper.UserEntityGoodResponseMapper;
import com.itrexgroup.skeleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "users", produces = "application/json;charset=UTF-8")
public class UserController {

    private final UserService userService;
    private final AbstractMapper<UserDto, UserEntity> userEntityDtoMapper = new UserEntityDtoMapper();
    private final AbstractMapper<UserShortResponseDto, UserEntity> userEntityGoodMessageDtoMapper = new UserEntityGoodResponseMapper();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserShortResponseDto>> list() {
        List<UserEntity> userEntities = userService.getAllUserEntity();
        return new ResponseEntity<>(userEntityGoodMessageDtoMapper.mapAllToDto(userEntities), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserShortResponseDto> readById(@PathVariable(value = "id") Long userId) {
        UserEntity userEntity = userService.readById(userId);
        return new ResponseEntity<>(userEntityGoodMessageDtoMapper.mapToDto(userEntity), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = userEntityDtoMapper.mapToEntity(userDto);
        UserEntity newUserEntity = userService.create(userEntity);

        return new ResponseEntity<>(userEntityDtoMapper.mapToDto(newUserEntity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable(value = "id") Long userId, @Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = userEntityDtoMapper.mapToEntity(userDto);
        userEntity.setId(userId);
        userService.update(userEntity);
        return new ResponseEntity<>(userEntityDtoMapper.mapToDto(userEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserMessageResponseDto> delete(@PathVariable(value = "id") Long userId) {
        UserEntity userEntity = userService.readById(userId);
        userService.delete(userEntity);
        return new ResponseEntity<>(new UserMessageResponseDto("User by login '" + userEntity.getLogin() + "' and ID '"
                + userEntity.getId() + "' was deleted SUCCESSFULLY"), HttpStatus.OK);
    }
}

