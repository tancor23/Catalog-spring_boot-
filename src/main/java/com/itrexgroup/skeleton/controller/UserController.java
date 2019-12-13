package com.itrexgroup.skeleton.controller;

import com.itrexgroup.skeleton.service.UserService;
import com.itrexgroup.skeleton.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String goToCreateUserPage() {
        return "user/create";
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUserPostMethod(@RequestParam String userId) {
        long id = Long.parseLong(userId);
        userService.delete(userService.getUserEntityByID(id));
        return "redirect:/main";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateUserPagePostMethod(@RequestParam String userId, @RequestParam String firstName, @RequestParam String lastName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/update");
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("firstName", firstName);
        modelAndView.addObject("lastName", lastName);
        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUserPostMethod(@RequestParam String userId, @RequestParam String firstName, @RequestParam String lastName) {
        long id = Long.parseLong(userId);
        UserEntity userEntity = userService.getUserEntityByID(id);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userService.update(userEntity);
        return "redirect:/main";
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String updateBookPostMethod(@RequestParam String firstName, @RequestParam String lastName) {
        UserEntity userEntity = new UserEntity(firstName, lastName);
        userService.create(userEntity);
        return "redirect:/main";
    }
}

