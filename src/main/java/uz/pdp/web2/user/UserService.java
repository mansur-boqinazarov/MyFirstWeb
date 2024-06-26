package uz.pdp.web2.user;


import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> users = new ArrayList<User>();
    public User login(String email, String password) {
        for (User user : users) {
            if (user.email.equals(email) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    public UserService(List<User> users) {
        this.users = users;
        this.users.add(new User("Mansurbek", "Boqinazarov" ,"mansur@gmail.com","1222","+998 91 155 24 98","12-22-2015"));
    }
}
