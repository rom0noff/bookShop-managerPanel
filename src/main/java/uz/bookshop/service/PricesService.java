package uz.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bookshop.entity.model.Prices;
import uz.bookshop.repository.PricesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PricesService {
    //
    @Autowired
    private PricesRepository pricesRepository;

    public Prices save(Prices prices){
        return pricesRepository.save(prices);
    }
    public List<Prices> findAll(){
        return (List<Prices>) pricesRepository.findAll();
    }
    public Optional<Prices> findById(Long id){
        return pricesRepository.findById(id);
    }
    public String deleteAll(){
        pricesRepository.deleteAll();
        return "deleteAll";
    }
    public String deleteId(Long id){
        pricesRepository.deleteById(id);
        return id + " deleted";
    }
}
