package br.com.jlgregorio.bookstore.repository;

import br.com.jlgregorio.bookstore.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByUserNameEquals(String userName);

}
