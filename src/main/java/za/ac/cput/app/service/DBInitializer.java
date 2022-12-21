package za.ac.cput.app.service;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.app.model.User;
import za.ac.cput.app.model.UserRole;
import za.ac.cput.app.repository.UserRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static za.ac.cput.app.model.UserRole.ADMIN;
import static za.ac.cput.app.model.UserRole.USER;

/**
 *
 * @since 3/13/2022
 */
@Service
@AllArgsConstructor
public class DBInitializer implements CommandLineRunner {

    private UserRepository repository;
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        try {
            repository.saveAll(Stream.of(
                        new User(
                                "John",
                                encoder.encode("john123"),
                                "john@doe.com",
                                Date.valueOf("2022-02-03"),
                                "Director",
                                "Male",
                                true,
                                52000L,
                                "Good communicator",
                                ADMIN.name()
                        ),
                        new User(
                                "Sarah",
                                encoder.encode("sarah123"),
                                "sarah@doe.com",
                                Date.valueOf(LocalDate.of(2005, Month.JANUARY, 20)),
                                "Accounting",
                                "Female",
                                true,
                                25000L,
                                "Good communicator",
                                USER.name()
                        ),
                        new User(
                                "Rose",
                                encoder.encode("rose123"),
                                "rose@doe.com",
                                Date.valueOf(LocalDate.of(1997, Month.FEBRUARY, 10)),
                                "Secretary",
                                "Female",
                                false,
                                10500L,
                                "Fast Learner",
                                USER.name()
                        ),
                        new User(
                                "James",
                                encoder.encode("james123"),
                                "james@doe.com",
                                Date.valueOf(LocalDate.of(2005, Month.APRIL, 2)),
                                "Spring Developer",
                                "Male",
                                false,
                                23125L,
                                "Fast Learner",
                                ADMIN.name()
                        )
                )
                .collect(Collectors.toList())
            );
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
