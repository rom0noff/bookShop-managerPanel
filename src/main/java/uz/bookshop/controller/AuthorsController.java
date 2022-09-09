package uz.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bookshop.entity.model.Authors;
import uz.bookshop.service.AuthorsService;

import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorsController {
    //
    @Autowired
    private AuthorsService authorsService;

    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestBody Authors authors){
        return ResponseEntity.ok(authorsService.save(authors));
    }
    @GetMapping("/showAll")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(authorsService.findAll());
    }
    @GetMapping("/showId")
    public ResponseEntity showById(@RequestParam("id") Long id){
        return ResponseEntity.ok(authorsService.findById(id));
    }
    @PutMapping("/change")
    public ResponseEntity changeInfo(@RequestBody Authors authors){
        Optional<Authors> info = authorsService.findById(authors.getId());
        if(authors.getName() != null){
            info.get().setName(authors.getName());
        }
        if(authors.getBooks() != null){
            info.get().setBooks(authors.getBooks());
        }
        return ResponseEntity.ok(authorsService.save(info.get()));
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllInfo(){
        return ResponseEntity.ok(authorsService.deleteAll());
    }
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity deleteIdInfo(@PathVariable Long id){
        return ResponseEntity.ok(authorsService.deleteId(id));
    }
}
