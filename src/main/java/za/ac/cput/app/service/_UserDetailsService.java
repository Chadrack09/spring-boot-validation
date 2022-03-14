package za.ac.cput.app.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.app.model.User;
import za.ac.cput.app.model._UserDetails;
import za.ac.cput.app.repository.UserRepository;

import java.util.Optional;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/13/2022 | 8:35 PM
 *
 * <p>Project app</p>
 */
@Service
@AllArgsConstructor
public class _UserDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(email);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new _UserDetails(user.get());
    }
}
