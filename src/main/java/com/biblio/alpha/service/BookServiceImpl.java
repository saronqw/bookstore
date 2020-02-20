package com.biblio.alpha.service;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.repository.IBooksRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final IBooksRepository booksRepository;

    public BookServiceImpl(IBooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Page<BookEntity> getBooks(PageRequest pageRequest) {
        return booksRepository.findAll(pageRequest);
    }

    @Override
    public BookEntity get(Long id) {
        return booksRepository.findAllByBookId(id);
    }

    @Override
    public void delete(Long id) {
        booksRepository.deleteByBookId(id);
    }


}
