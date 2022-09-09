package uz.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bookshop.entity.model.Comments;
import uz.bookshop.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    //
    @Autowired
    private CommentRepository commentRepository;

    public Comments save(Comments comments){
        return commentRepository.save(comments);
    }
    public List<Comments> findAll(){
        return (List<Comments>) commentRepository.findAll();
    }
    public Optional<Comments> findById(Long id){
        return commentRepository.findById(id);
    }
    public String deleteAll(){
        commentRepository.deleteAll();
        return "deleteAll";
    }
    public String deleteId(Long id){
        commentRepository.deleteById(id);
        return id + " deleted";
    }
}
