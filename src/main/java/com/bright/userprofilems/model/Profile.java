package com.bright.userprofilems.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private Long id;
    @Column(name = "first_name", length = 25)
    private String firstName;
    @Column(name = "last_name", length = 25)
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(length = 25)
    private String email;
    @Column(length = 12)
    private String phoneNumber;
    @Column(length = 1000)
    private String bio;
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private User user;

    public Profile(String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
    }
}
