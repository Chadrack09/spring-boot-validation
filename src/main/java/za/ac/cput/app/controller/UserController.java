package za.ac.cput.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.app.model.User;
import za.ac.cput.app.repository.UserRepository;

import java.util.List;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/13/2022 | 10:44 AM
 *
 * <p>Project app</p>
 */
@Controller
@AllArgsConstructor
public class UserController {

    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getAll() {
        return repository.findAll();
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


}
