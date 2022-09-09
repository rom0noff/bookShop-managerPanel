package uz.bookshop.entity.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "books")
public class Books implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Authors authors;

    @OneToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comments> comments = new LinkedList<>();

    @OneToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Prices> prices = new LinkedList<>();

    @OneToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserPurchases> userPurchases = new LinkedList<>();

}
