package com.biblio.alpha.repository;

import com.biblio.alpha.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBooksRepository extends PagingAndSortingRepository<BookEntity, Long> {
    Page<BookEntity> findAll(Pageable pageable);
    BookEntity findAllByBookId(Long id);
    void deleteByBookId(Long id);
}
