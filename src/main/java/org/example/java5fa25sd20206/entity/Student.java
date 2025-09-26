package org.example.java5fa25sd20206.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    @Id
    private Long id;
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;
    @Email(message = "Please enter a valid Email")
    // fpt.edu.vn
    private String email;
    @Pattern(regexp = "^(0)\\d{9}$", message = "Invalid phone number")
    private String phone;
}
