package za.ac.cput.app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/13/2022 | 8:55 PM
 *
 * <p>Project app</p>
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;


    @Test
    void findByUsername() {
        System.out.println(repository.findByUsername("John"));
    }
}