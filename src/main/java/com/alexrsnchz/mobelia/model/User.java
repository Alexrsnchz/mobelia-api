package com.alexrsnchz.mobelia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 30, message = "The alias must be between 3 and 30 characters")
    private String alias;

    @NotBlank(message = "The email is required")
    @Email(message = "The email must be a valid email address")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "The email must be a valid email address")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "The password is required")
    @Size(min = 8, message = "The password must be at least 8 characters long")
    @Column(nullable = false, length = 60)
    private String password;

    @Size(max = 255, message = "The address cannot be more than 255 characters long")
    private String address;

    @Pattern(regexp = "^[+][0-9]{1,4}[0-9]{10,15}$", message = "The phone number must be a valid format")
    @Column(length = 20)
    private String phone;

    public User() {
    }

    public User(Long id, String alias, String email, String password, String address, String phone) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
