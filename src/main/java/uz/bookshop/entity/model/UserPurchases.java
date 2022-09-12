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
@Table(name = "userPurchases")
public class UserPurchases implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_at")
    private String create_at;
    @Column(name = "price")
    private String price;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books books;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
