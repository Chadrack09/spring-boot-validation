package za.ac.cput.app.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;

/**
 * @author Chadrack B. Boudzoumou
 * @email 219383847@mycput.ac.za
 * @student 219383847
 * @uni Cape Peninsula University Of Technology
 * @since 3/13/2022 | 10:37 AM
 *
 * <p>Project app</p>
 */
@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "No empty value allowed")
    @NotNull(message = "No empty value allowed")
    @Size(min = 3, max = 10, message = "Username should have 3 to 10 chars")
    @Column(nullable = false)
    private String username;

    @NotNull(message = "No empty value allowed")
    @NotEmpty(message = "No empty value allowed")
    @Size(min = 5, max = 10, message = "Password should have 5 to 10 chars")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "No empty value allowed")
    @NotEmpty(message = "No empty value allowed")
    @Email(message = "Please enter valid email")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "No empty value allowed")
    @Column(nullable = false)
    private Date birthday;


    @NotNull(message = "No empty value allowed")
    @Column(nullable = false)
    private String profession;


    private String gender;
    private boolean married;

    @NotNull(message = "No empty value allowed")
    @Min(value = 1000L, message = "Minimum income set to 1000")
    @Max(value = 90000L, message = "Maximun income set to 90000")
    @Column(nullable = false)
    private Long income;

    private String description;

    public User(String username, String password, String email,
                Date birthday, String profession, String gender,
                boolean married, Long income, String description) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.profession = profession;
        this.gender = gender;
        this.married = married;
        this.income = income;
        this.description = description;
    }
}
