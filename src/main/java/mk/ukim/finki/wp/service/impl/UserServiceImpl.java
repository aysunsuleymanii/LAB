package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wp.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.wp.repository.jpa.UserRepository;
import mk.ukim.finki.wp.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    public final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, String repeatedPassword, String name, String surname) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }


        if (!password.equals(repeatedPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(username, encodedPassword, name, surname);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles("USER")
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

}
