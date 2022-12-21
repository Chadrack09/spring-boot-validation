package za.ac.cput.app.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @since 3/13/2022
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