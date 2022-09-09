package uz.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bookshop.entity.model.UserPurchases;
import uz.bookshop.repository.UserPurchasesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserPurchasesService {
    //
    @Autowired
    private UserPurchasesRepository user;

    public UserPurchases save(UserPurchases userPurchases){
        return user.save(userPurchases);
    }

    public List<UserPurchases> findAll(){
        return (List<UserPurchases>) user.findAll();
    }

    public Optional<UserPurchases> findById(Long id){
        return user.findById(id);
    }

    public String deleteAll(){
        user.deleteAll();
        return "deleteAll";
    }
    public String deleteById(Long id){
        user.deleteById(id);
        return id + " deleted";
    }
}
