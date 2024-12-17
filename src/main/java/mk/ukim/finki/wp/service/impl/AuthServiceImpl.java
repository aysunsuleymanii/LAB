package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wp.repository.jpa.UserRepository;
import mk.ukim.finki.wp.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsername(username)
                .orElseThrow(InvalidUserCredentialsException::new);
    }
}



