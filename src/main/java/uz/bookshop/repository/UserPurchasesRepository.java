package uz.bookshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.bookshop.entity.model.UserPurchases;

@Repository
public interface UserPurchasesRepository extends CrudRepository<UserPurchases, Long> {

}
