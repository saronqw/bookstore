package com.biblio.alpha.controller;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.model.api.request.BooksRequest;
import com.biblio.alpha.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private BookServiceImpl bookServiceImpl;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/books",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public Page<BookEntity> get(@RequestBody BooksRequest booksRequest) {
        logger.info(booksRequest.toString());
        if (booksRequest.getRevert()) {
            return bookServiceImpl.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort()).descending()));
        }
        return bookServiceImpl.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort())));
    }


}
