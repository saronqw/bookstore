package com.biblio.alpha.controller;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.model.api.request.BookParamsRequest;
import com.biblio.alpha.model.api.request.BooksRequest;
import com.biblio.alpha.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService BookService) {
        this.bookService = BookService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public Page<BookEntity> getList(@RequestBody BooksRequest booksRequest) {
        logger.info(booksRequest.toString());
        if (booksRequest.getRevert()) {
            return bookService.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort()).descending()));
        }
        return bookService.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort())));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<BookEntity> get(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<BookEntity> add(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/{id}",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<Boolean> edit(
            @RequestBody BookParamsRequest bookParamsRequest,
            @PathVariable Long id) {
        logger.info(bookParamsRequest.toString());
        return ResponseEntity.ok(bookService.editBook(bookParamsRequest, id));
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
