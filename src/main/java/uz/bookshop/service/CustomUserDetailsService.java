package uz.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import uz.bookshop.entity.model.Users;
import uz.bookshop.repository.UsersRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    //
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users myUser = usersRepository.findByLogin(username);

        if (myUser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(myUser.getLogin()).password(myUser.getPassword()).authorities("USER").build();
        return user;
    }
}
