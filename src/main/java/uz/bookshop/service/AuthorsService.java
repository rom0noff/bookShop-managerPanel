package uz.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bookshop.entity.model.Authors;
import uz.bookshop.repository.AuthorsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {
    //
    @Autowired
    private AuthorsRepository authorsRepository;

    public Authors save(Authors authors){
        return authorsRepository.save(authors);
    }
    public List<Authors> findAll(){
        return (List<Authors>) authorsRepository.findAll();
    }
    public Optional<Authors> findById(Long id){
        return authorsRepository.findById(id);
    }
    public String deleteAll(){
        authorsRepository.deleteAll();
        return "deleteAll";
    }
    public String deleteId(Long id){
        authorsRepository.deleteById(id);
        return id + " deleted";
    }
}
