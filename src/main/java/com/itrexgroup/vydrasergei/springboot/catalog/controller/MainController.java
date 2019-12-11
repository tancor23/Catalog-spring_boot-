package com.itrexgroup.vydrasergei.springboot.catalog.controller;

import com.itrexgroup.vydrasergei.springboot.catalog.dto.BookDto;
import com.itrexgroup.vydrasergei.springboot.catalog.dto.UserDto;
import com.itrexgroup.vydrasergei.springboot.catalog.domain.BookEntity;
import com.itrexgroup.vydrasergei.springboot.catalog.domain.UserEntity;
import com.itrexgroup.vydrasergei.springboot.catalog.mapper.AbstractMapper;
import com.itrexgroup.vydrasergei.springboot.catalog.mapper.BookMapper;
import com.itrexgroup.vydrasergei.springboot.catalog.mapper.UserMapper;
import com.itrexgroup.vydrasergei.springboot.catalog.service.BookService;
import com.itrexgroup.vydrasergei.springboot.catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public MainController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET)
    public String prepareMainViewGetMethod(ModelMap model) {
        AbstractMapper<UserDto, UserEntity> userMapper = new UserMapper();
        List<UserDto> userDtoList = userMapper.mapAllToDto(userService.getAllUserEntity());
        AbstractMapper<BookDto, BookEntity> bookMapper = new BookMapper();
        List<BookDto> bookDtoList = bookMapper.mapAllToDto(bookService.getAllBookEntity());
        model.addAttribute("users", userDtoList);
        model.addAttribute("books", bookDtoList);
        return "main_page";
    }
}

