package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User register(String username, String password, String repeatedPassword, String name, String surname);
}
