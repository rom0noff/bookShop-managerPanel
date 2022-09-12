package uz.bookshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.bookshop.entity.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    //
    Users findByName(String user);
    Users findByLogin(String login);
    boolean existsByLogin(String login);

}
