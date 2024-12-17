package mk.ukim.finki.wp.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.service.AuthService;
import mk.ukim.finki.wp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final AuthService authService;


    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            user = authService.login(username, password);
            request.getSession().setAttribute("user", user);
            // Redirect to the home page
            return "redirect:/register";
        } catch (RuntimeException ex) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", ex.getMessage());
            return "login";
        }
    }

}
