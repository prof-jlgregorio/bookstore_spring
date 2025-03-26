package br.com.jlgregorio.bookstore.repository;

import br.com.jlgregorio.bookstore.model.GenderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderModel, Long> {

}
