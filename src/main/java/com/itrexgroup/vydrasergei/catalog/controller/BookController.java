package com.itrexgroup.vydrasergei.catalog.controller;

import com.itrexgroup.vydrasergei.catalog.domain.BookEntity;
import com.itrexgroup.vydrasergei.catalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBookGetMethod() {
        return "create_book_page";
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBookPostMethod(@RequestParam String bookName, @RequestParam String authorName, @RequestParam String countOfPage) {
        int page;
        try {
            page = Integer.parseInt(countOfPage);
        } catch (NumberFormatException e) {
            page = 1;
        }
        BookEntity bookEntity = new BookEntity(bookName, authorName, page);
        bookService.create(bookEntity);
        return "redirect:/main";
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteBookPostMethod(@RequestParam String bookId) {
        long id = Long.parseLong(bookId);
        bookService.delete(bookService.getBookEntityByID(id));
        return "redirect:/main";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateBookPageGetMethod(@RequestParam String bookId, @RequestParam String bookName, @RequestParam String authorName, @RequestParam String countOfPage) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update_book_page");
        modelAndView.addObject("bookId", bookId);
        modelAndView.addObject("bookName", bookName);
        modelAndView.addObject("authorName", authorName);
        modelAndView.addObject("countOfPage", countOfPage);
        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBookPostMethod(@RequestParam String bookId, @RequestParam String bookName, @RequestParam String authorName, @RequestParam String countOfPage) {
        Long id = Long.parseLong(bookId);
        int page;
        try {
            page = Integer.parseInt(countOfPage);
        } catch (NumberFormatException e) {
            page = 1;
        }
        BookEntity bookEntity = bookService.getBookEntityByID(id);
        bookEntity.setName(bookName);
        bookEntity.setAuthor(authorName);
        bookEntity.setPage(page);
        bookService.update(bookEntity);
        return "redirect:/main";
    }
}

