package com.biblio.alpha.service;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.model.api.request.BookParamsRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Book;


public interface BookService {
    Page<BookEntity> getBooks(PageRequest pageRequest);
    BookEntity getBookById(Long id);
    BookEntity add(BookParamsRequest bookParamsRequest);
    BookEntity editBook(BookParamsRequest bookParamsRequest, Long id);
    BookEntity delete(Long id);
}
