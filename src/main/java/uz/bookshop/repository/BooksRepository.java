package uz.bookshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.bookshop.entity.model.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long> {
}
