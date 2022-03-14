package za.ac.cput.app.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.app.repository.UserRepository;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/13/2022 | 10:42 AM
 *
 * <p>Project app</p>
 */
@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
}
