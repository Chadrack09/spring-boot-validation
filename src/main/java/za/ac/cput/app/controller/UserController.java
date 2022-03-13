package za.ac.cput.app.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.cput.app.model.User;
import za.ac.cput.app.repository.UserRepository;

import javax.validation.Valid;

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
    private static final Logger log = LoggerFactory.getLogger(User.class);

    @GetMapping("/register")
    public String registerPage(@ModelAttribute User user,  Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {

            log.info(">> User : {} ", user.toString());
            log.info(">> Errors : {} ", bindingResult.getFieldErrors().toString());
            return "register";
        };
        return "redirect:/";
    }
}
