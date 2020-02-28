package com.biblio.alpha.service;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.model.api.request.BookParamsRequest;
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
    public BookEntity getBookById(Long id) {
        return booksRepository.findAllByBookId(id);
    }

    @Override
    public Boolean editBook(BookParamsRequest bookParamsRequest, Long id) {
        BookEntity currentBook = getBookById(id);
        currentBook.edit(bookParamsRequest);
        booksRepository.save(currentBook);
        return true;
    }

    @Override
    public void delete(Long id) {
        booksRepository.deleteByBookId(id);
    }

    @Override
    public BookEntity add(BookParamsRequest bookParamsRequest) {
        BookEntity addBook = new BookEntity();
        addBook.edit(bookParamsRequest);
        booksRepository.save(addBook);
        return addBook;
    }
}
