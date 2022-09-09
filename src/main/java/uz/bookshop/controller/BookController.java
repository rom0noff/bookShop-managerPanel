package uz.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bookshop.entity.model.Books;
import uz.bookshop.service.BooksService;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {
    //
    @Autowired
    private BooksService booksService;

    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestBody Books books){
        return ResponseEntity.ok(booksService.save(books));
    }
    @GetMapping("/showAll")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(booksService.findAll());
    }
    @GetMapping("/showId")
    public ResponseEntity showById(@RequestParam("id") Long id){
        return ResponseEntity.ok(booksService.findById(id));
    }
    @PutMapping("/change")
    public ResponseEntity changeInfo(@RequestBody Books books){
        Optional<Books> info = booksService.findById(books.getId());
        if(books.getName() != null){
            info.get().setName(books.getName());
        }
        if(books.getAuthors() != null){
            info.get().setAuthors(books.getAuthors());
        }
        if(books.getComments() != null){
            info.get().setComments(books.getComments());
        }
        return ResponseEntity.ok(booksService.save(info.get()));
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllInfo(){
        return ResponseEntity.ok(booksService.deleteAll());
    }
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity deleteIdInfo(@PathVariable Long id){
        return ResponseEntity.ok(booksService.deleteId(id));
    }
}
