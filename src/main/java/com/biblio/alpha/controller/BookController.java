package com.biblio.alpha.controller;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.model.api.request.BooksRequest;
import com.biblio.alpha.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private BookService BookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService BookService) {
        this.BookService = BookService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/books",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public Page<BookEntity> getBooks(@RequestBody BooksRequest booksRequest) {
        logger.info(booksRequest.toString());
        if (booksRequest.getRevert()) {
            return BookService.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort()).descending()));
        }
        return BookService.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort())));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/book/{id}",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public BookEntity get(@PathVariable Long id) {
        return BookService.get(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/book/{id}",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public BookEntity delete(@PathVariable Long id) {
        return BookService.get(id);
    }



}
