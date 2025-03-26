package br.com.jlgregorio.bookstore.repository;

import br.com.jlgregorio.bookstore.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {
}
