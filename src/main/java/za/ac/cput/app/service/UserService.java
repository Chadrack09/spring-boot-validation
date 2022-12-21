package za.ac.cput.app.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.app.repository.UserRepository;

/**
 *
 * @since 3/13/2022
 */
@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
}
