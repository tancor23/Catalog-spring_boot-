package com.itrexgroup.vydrasergei.springboot.catalog.controller;

import com.itrexgroup.vydrasergei.springboot.catalog.dto.BookDto;
import com.itrexgroup.vydrasergei.springboot.catalog.dto.UserDto;
import com.itrexgroup.vydrasergei.springboot.catalog.domain.BookEntity;
import com.itrexgroup.vydrasergei.springboot.catalog.domain.UserEntity;
import com.itrexgroup.vydrasergei.springboot.catalog.mapper.AbstractMapper;
import com.itrexgroup.vydrasergei.springboot.catalog.mapper.BookMapper;
import com.itrexgroup.vydrasergei.springboot.catalog.mapper.UserMapper;
import com.itrexgroup.vydrasergei.springboot.catalog.service.BookService;
import com.itrexgroup.vydrasergei.springboot.catalog.service.UserBookService;
import com.itrexgroup.vydrasergei.springboot.catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Transactional
@Controller
@RequestMapping(value = "/user_book", produces = "application/json;charset=UTF-8")
public class UserBookController {

    private final UserService userService;
    private final BookService bookService;
    private final UserBookService userBookService;
    private final AbstractMapper<UserDto, UserEntity> userMapper = new UserMapper();
    private final AbstractMapper<BookDto, BookEntity> bookMapper = new BookMapper();

    @Autowired
    public UserBookController(UserService userService, BookService bookService, UserBookService userBookService) {
        this.userService = userService;
        this.bookService = bookService;
        this.userBookService = userBookService;
    }

    @Transactional
    @RequestMapping(value = "/user_info", method = RequestMethod.POST)
    public String goToUserInfoPagePostMethod(ModelMap model, @RequestParam String userId) {
        UserEntity userEntity = userService.getUserEntityByID(Long.parseLong(userId));
        UserDto userDto = userMapper.mapToDto(userEntity);
        model.addAttribute("userDto", userDto);
        model.addAttribute("userBookSize", userDto.getSimpleBookDtoList().size());
        return "user_book_page";
    }

    @Transactional
    @RequestMapping(value = "/book_info", method = RequestMethod.POST)
    public String goToBookInfoPagePostMethod(ModelMap model, @RequestParam String bookId) {
        BookEntity bookEntity = bookService.getBookEntityByID(Long.parseLong(bookId));
        BookDto bookDto = bookMapper.mapToDto(bookEntity);
        model.addAttribute("bookDto", bookDto);
        model.addAttribute("bookUserSize", bookDto.getSimpleUserDtoList().size());
        return "book_user_page";
    }

    @Transactional(readOnly = true)
    @RequestMapping(value = "/add_mapping", method = RequestMethod.GET)
    public ModelAndView goToAddMappingGetMethod(ModelAndView model) {
        List<UserEntity> userEntityList = userService.getAllUserEntity();
        List<UserDto> userDtoList = userMapper.mapAllToDto(userEntityList);
        List<BookEntity> bookEntityList = bookService.getAllBookEntity();
        List<BookDto> bookDtoList = bookMapper.mapAllToDto(bookEntityList);
        model.addObject("userDtoList", userDtoList);
        model.addObject("bookDtoList", bookDtoList);
        model.setViewName("add_user_book_mapping");
        return model;
    }

    @Transactional
    @RequestMapping(value = "/add_mapping", method = RequestMethod.POST)
    public ModelAndView goToAddMappingPostMethod(@RequestParam String userSelect, @RequestParam String bookSelect) {
        ModelAndView model = new ModelAndView();
        long userId = Long.parseLong(userSelect);
        long bookId = Long.parseLong(bookSelect);
        if (userBookService.isExist(userId, bookId)){
            model.addObject("dbAlert","This associating is in DB!");
        }else {
            userBookService.create(userId, bookId);
            model.addObject("dbAlert","The associating was added successfully");
        }
        return goToAddMappingGetMethod(model);
    }


}

