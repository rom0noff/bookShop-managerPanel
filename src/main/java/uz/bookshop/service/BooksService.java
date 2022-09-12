package uz.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bookshop.entity.model.Books;
import uz.bookshop.repository.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    //
    @Autowired
    private BooksRepository booksRepository;

    public Books save(Books books){
        return booksRepository.save(books);
    }
    public List<Books> findAll(){
        return (List<Books>) booksRepository.findAll();
    }
    public Optional<Books> findById(Long id){
        return booksRepository.findById(id);
    }
    public String deleteAll(){
        booksRepository.deleteAll();
        return "deleteAll";
    }
    public String deleteId(Long id){
        booksRepository.deleteById(id);
        return id + " deleted";
    }

}
