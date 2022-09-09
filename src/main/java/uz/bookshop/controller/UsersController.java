package uz.bookshop.controller;

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
        List<Users> show = userService.findAll();
        Date date = new Date();
        Map<String,String> infoAdd = null;
        if(letter.equals("week")) {
            int i = 0;
            while (i > 7){
               infoAdd.put(show.get((show.size()-i)).getLogin(), show.get((show.size()-i)).getName());
                i++;
            }
        }
        if(letter.equals("month")){
            for (int i = 0; i < show.size(); i++){
                String[] list = show.get(i).getCreateDate().split(" ");
                if(String.valueOf(1900+date.getYear()).equals(list[5])){
//                    if(list[1]){
//
//                    }
                }
            }
        }
       return ResponseEntity.ok(infoAdd);
    }

//    public static void main(String[] args) {
//        Calendar calendar = new GregorianCalendar();
//        YearMonth yearMonth = YearMonth.now();
//        String add = String.valueOf(yearMonth.getMonth()).toLowerCase(Locale.ROOT).substring(0,3);
//        System.out.println(add);
//        String list = String.valueOf(calendar.getTime());
//        String[] now = list.split(" ");
//        System.out.println(now[1]);
//    }

}
