package uz.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bookshop.entity.model.UserPurchases;
import uz.bookshop.service.UserPurchasesService;

@RestController
@RequestMapping("/api/purchases")
public class UserPurchasesController {
    //
    @Autowired
    private UserPurchasesService userPurchasesService;

    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestBody UserPurchases userPurchases){
        return ResponseEntity.ok(userPurchasesService.save(userPurchases));
    }
    @GetMapping("/showAll")
    public ResponseEntity showAllInfo(){
        return ResponseEntity.ok(userPurchasesService.findAll());
    }
    @GetMapping("/showId")
    public ResponseEntity showById(@RequestBody Long id){
        return ResponseEntity.ok(userPurchasesService.findById(id));
    }
}
