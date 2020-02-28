package com.biblio.alpha.controller;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.model.api.request.BookParamsRequest;
import com.biblio.alpha.model.api.request.BooksRequest;
import com.biblio.alpha.service.BookService;
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

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public Page<BookEntity> getList(@RequestBody BooksRequest booksRequest) {
        if (booksRequest.getCount() == null) {
            booksRequest.setCount(10);
        }

        if (booksRequest.getTypeSort() == null) {
            booksRequest.setTypeSort("title");
        }

        if (booksRequest.getRevert() == null) {
            booksRequest.setRevert(false);
        }

        if (booksRequest.getRevert()) {
            return bookService.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort()).descending()));
        } else {
            return bookService.getBooks(PageRequest.of(booksRequest.getPage(), booksRequest.getCount(), Sort.by(booksRequest.getTypeSort())));
        }
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
            path = "/add",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<BookEntity> add(@RequestBody BookParamsRequest bookParamsRequest) {
        return ResponseEntity.ok(bookService.add(bookParamsRequest));
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/edit/{id}",
            consumes = "application/json",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<BookEntity> edit(
            @RequestBody BookParamsRequest bookParamsRequest,
            @PathVariable Long id) {
        return ResponseEntity.ok(bookService.editBook(bookParamsRequest, id));
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/delete/{id}")
    @ResponseBody
    public ResponseEntity<BookEntity> delete(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.delete(id));
    }
}
