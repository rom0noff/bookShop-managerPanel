package uz.bookshop.entity.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginUsers implements Serializable {
    //
    private String userName;
    private String password;
}
