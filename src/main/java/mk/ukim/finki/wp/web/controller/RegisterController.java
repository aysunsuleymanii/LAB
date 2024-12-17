package mk.ukim.finki.wp.web.controller;

import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;


    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String repeatedPassword,
                           Model model
    ) {

        try {
            this.userService.register(username, password, repeatedPassword, name, surname);
            return "redirect:/login";
        } catch (RuntimeException ex) {
            // Redirect to the register page with an error message
            return "redirect:/register?error=" + ex.getMessage();
        }

    }
}
