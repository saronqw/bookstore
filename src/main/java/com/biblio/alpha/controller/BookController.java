package com.biblio.alpha.controller;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.model.api.request.BooksRequest;
import com.biblio.alpha.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private BookService BookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService BookService) {
        this.BookService = BookService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public Page<BookEntity> getList(@RequestBody BooksRequest booksRequest) {
        logger.info(booksRequest.toString());
        if (booksRequest.getRevert()) {
            return BookService.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort()).descending()));
        }
        return BookService.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort())));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<BookEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(BookService.get(id));
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        BookService.delete(id);
    }



}
