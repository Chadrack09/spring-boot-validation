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
 *
 * @since 3/13/2022
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
