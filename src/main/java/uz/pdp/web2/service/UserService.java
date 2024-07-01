package uz.pdp.web2.service;


import uz.pdp.web2.repository.UserRepository;
import uz.pdp.web2.model.User;

import java.util.List;
import java.util.Objects;

public class UserService {
    private final UserRepository repository = new UserRepository();

    public User login(String email, String password) {
        for (User user : getAll()) {
            if (user.email.equals(email) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean signUp(User user) {
        for (User user1 : getAll()) {
            if (Objects.equals(user1.email, user.email)) {
                return false;
            }
        }
        repository.save(user);
        return true;
    }

    public List<User> getAll() {
        return repository.getAll();
    }


}
