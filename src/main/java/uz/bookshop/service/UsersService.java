package uz.bookshop.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.bookshop.entity.model.Users;
import uz.bookshop.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService {
    //
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users createSave(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }
    public boolean checkUserName(String login){
        return userRepository.existsByLogin(login);
    }

    public List<Users> findAll(){
       return (List<Users>) userRepository.findAll();
    }
}
