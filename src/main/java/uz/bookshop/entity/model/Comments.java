package uz.bookshop.entity.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "comments")
public class Comments implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private String create_at;

    @ManyToOne
    @JoinColumn(name = "books_id")
    private Books books;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

}
