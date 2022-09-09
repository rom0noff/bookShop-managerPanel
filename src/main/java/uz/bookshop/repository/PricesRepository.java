package uz.bookshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.bookshop.entity.model.Prices;

@Repository
public interface PricesRepository extends CrudRepository<Prices, Long> {
}
