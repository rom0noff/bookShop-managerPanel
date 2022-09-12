package uz.bookshop.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bookshop.entity.model.Users;
import uz.bookshop.service.UsersService;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UsersController {
    //
    @Autowired
    private UsersService userService;

    @PostMapping("/register")
    public ResponseEntity createInfo(@RequestBody Users users){
        Calendar calendar = new GregorianCalendar();
        users.setCreateDate(String.valueOf(calendar.getTime()).toLowerCase(Locale.ROOT));
        if(!checkPassword(users.getPassword())){
            return new ResponseEntity<>("5 ta raqamdan kop bolishi kerak",HttpStatus.BAD_REQUEST);
        }
        if(userService.checkUserName(users.getLogin())){
            return new ResponseEntity("Bu user oldin ro'yxardan o'tgan.",HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.createSave(users));
    }

    private Boolean checkPassword(String password){
        return password.length() > 5;
    }

    @GetMapping("/show")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/showUser/{letter}")
    public ResponseEntity showUserInfo(@PathVariable String letter){

       return ResponseEntity.ok(null);
    }
}
