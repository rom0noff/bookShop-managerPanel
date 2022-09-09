package uz.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bookshop.entity.model.Comments;
import uz.bookshop.service.CommentService;

import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/api/comment")
public class CommentsController {
    //
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity createInfo(@RequestBody Comments comments){
        Calendar now = new GregorianCalendar();
        comments.setCreate_at(String.valueOf(now.getTime()));
        return ResponseEntity.ok(commentService.save(comments));
    }
    @GetMapping("/showAll")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(commentService.findAll());
    }
    @GetMapping("/showId")
    public ResponseEntity showById(@RequestParam("id") Long id){
        return ResponseEntity.ok(commentService.findById(id));
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllInfo(){
        return ResponseEntity.ok(commentService.deleteAll());
    }
    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity deleteIdInfo(@PathVariable Long id){
        return ResponseEntity.ok(commentService.deleteId(id));
    }
}
