package za.ac.cput.app.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import za.ac.cput.app.model.User;
import za.ac.cput.app.model.UserRole;
import za.ac.cput.app.repository.UserRepository;

import javax.validation.Valid;
import java.util.Optional;

/**
 *
 * @since 3/13/2022
 */
@Controller
@AllArgsConstructor
public class UserController {

    private UserRepository repository;
    private PasswordEncoder encoder;
    private static final Logger log = LoggerFactory.getLogger(User.class);

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/register")
    public String registerPage(@ModelAttribute User user,  Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Valid User user,
                       BindingResult bindingResult, RedirectAttributes ra) {
        
        if(repository.findByEmail(user.getEmail()).isPresent()) 
            bindingResult.addError(new FieldError(
                    "user", "email", "Email already taken"));
        
        if(bindingResult.hasErrors()) {
            return "register";
        }
        user.setRole(UserRole.USER.name());
        user.setPassword(encoder.encode(user.getPassword()));

        repository.save(user);
        ra.addFlashAttribute("message", "User successfully registered");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/users")
    public String getAll(Model model) {
        model.addAttribute("users", repository.findAll());
        return "user";
    }

    @GetMapping("/denied")
    public String accessDeniedPage(){
        return "denied";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("users", repository.findAll());
        return "admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/admin";
    }
}
