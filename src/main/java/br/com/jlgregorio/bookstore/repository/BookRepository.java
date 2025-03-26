package br.com.jlgregorio.bookstore.repository;

import br.com.jlgregorio.bookstore.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
}
