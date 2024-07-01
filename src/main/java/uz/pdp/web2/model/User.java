package uz.pdp.web2.model;

import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public LocalDate birthDate;

    public User(String firstName, String lastName, String email, String password, String phone, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birthDate = birthDate;
    }
}
