package com.spring.project.spring.user_system.entities;

import com.spring.project.spring.user_system.constants.AppConstants;
import com.spring.project.spring.user_system.validator.annotations.Password;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false)
    @NonNull
    @Size(min = 4, max = 30, message = AppConstants.INVALID_USERNAME)
    private String username;

    @Password(minLength = 6,
            maxLength = 50,
            containsDigit = true,
            containsLowerCase = true,
            containsUpperCase = true,
            containsSpecialSymbols = true)
    @Column(nullable = false)
    @NonNull
    private String password;

    @Email
    @Column(nullable = false)
    @NonNull
    private String email;

    @Column(name = "registered_on")
    private LocalDate registeredOn;

    @Column(name = "last_time_logged_in")
    private LocalDate lastTimeLoggedIn;

    @Column
    @Min(value = 1, message = AppConstants.AGE_TOO_LOW)
    @Max(value = 120, message = AppConstants.AGE_TOO_HIGH)
    private int age;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Lob
    @Size(max = 1024 * 1024)
    private Picture picture;

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;

    @OneToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;

}
