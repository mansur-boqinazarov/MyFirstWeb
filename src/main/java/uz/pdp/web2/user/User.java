package uz.pdp.web2.user;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public String birthDate;

}
