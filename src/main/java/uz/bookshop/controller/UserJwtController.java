package uz.bookshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bookshop.entity.model.LoginUsers;
import uz.bookshop.entity.model.Users;
import uz.bookshop.repository.UsersRepository;
import uz.bookshop.securityJWT.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jwt")
public class UserJwtController {
    //
    private final AuthenticationManagerBuilder managerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UsersRepository usersRepository;

    public UserJwtController(AuthenticationManagerBuilder authenticationManagerBuilder, JwtTokenProvider jwtTokenProvider, UsersRepository usersRepository) {
        this.managerBuilder = authenticationManagerBuilder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.usersRepository = usersRepository;
    }

    @PostMapping("/login")
    public ResponseEntity loginInfo(@RequestBody LoginUsers loginUsers){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUsers.getUserName(), loginUsers.getPassword());
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if(loginUsers == null){
            throw new UsernameNotFoundException("Not available");
        }
        String token = jwtTokenProvider.createToken(loginUsers.getUserName(), authentication);
        Map<Object, Object> map = new HashMap<>();
        map.put("username", loginUsers.getUserName());
        map.put("token", token);
        return ResponseEntity.ok(map);
    }
}
