package uz.bookshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.bookshop.entity.model.Comments;

@Repository
public interface CommentRepository extends CrudRepository<Comments, Long> {
}
