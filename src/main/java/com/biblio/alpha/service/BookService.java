package com.biblio.alpha.service;

import com.biblio.alpha.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public interface BookService {

    Page<BookEntity> getBooks(PageRequest pageRequest);

    BookEntity get(Long id);

    void delete(Long id);
}
