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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.itrexgroup.skeleton.constant.Response.USER_BY_ID_WAS_DELETED_RESPONSE;

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
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserShortResponseDto> list() {
        List<UserEntity> userEntities = userService.getAllUserEntity();
        return userEntityGoodMessageDtoMapper.mapAllToDto(userEntities);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserShortResponseDto readById(@PathVariable(value = "id") Long userId) {
        UserEntity userEntity = userService.readById(userId);
        return userEntityGoodMessageDtoMapper.mapToDto(userEntity);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto create(@Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = userEntityDtoMapper.mapToEntity(userDto);
        UserEntity newUserEntity = userService.create(userEntity);
        return userEntityDtoMapper.mapToDto(newUserEntity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDto update(@PathVariable(value = "id") Long userId, @Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = userEntityDtoMapper.mapToEntity(userDto);
        userEntity.setId(userId);
        userService.update(userEntity);
        return userEntityDtoMapper.mapToDto(userEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserMessageResponseDto delete(@PathVariable(value = "id") Long userId) {
        userService.delete(userId);
        return new UserMessageResponseDto(String.format(USER_BY_ID_WAS_DELETED_RESPONSE, userId));
    }
}

