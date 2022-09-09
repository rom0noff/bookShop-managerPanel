package uz.bookshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.bookshop.entity.model.Authors;

@Repository
public interface AuthorsRepository extends CrudRepository<Authors, Long> {
}
