package com.biblio.alpha.service;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.repository.IBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService implements BookServiceImpl {

    @Autowired
    private IBooksRepository booksRepository;

    @Override
    public Page<BookEntity> getBooks(PageRequest pageRequest) {
        return booksRepository.findAll(pageRequest);
    }
}
