package com.alexrsnchz.mobelia.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Schema(description = "User model / entity")
public class User {
    /*

    id:         Long    /  Required  /  Unique
    alias:      String  /  Nullable
    email:      String  /  Required  /  Unique
    password:   String  /  Required
    address:    Address /  Nullable
    phone:      String  /  Nullable
    createdAt   Date    /  Required
    updatedAt   Date    /  Required

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 25, message = "The alias cannot be more than 25 characters long")
    @Column(length = 25)
    @Schema(description = "Alias of the user")
    private String alias;

    @NotBlank(message = "The email cannot be empty")
    @Email(message = "The string must be a valid email")
    @Column(nullable = false, unique = true, length = 244)
    @Schema(description = "Email of the user")
    private String email;

    @NotBlank(message = "The password cannot be empty")
    @Size(max = 60, message = "The password cannot be more than 60 characters long")
    @Column(nullable = false, length = 60)
    @Schema(description = "Password of the user", hidden = true)
    private String password;

    @Schema(description = "Address associated with the user")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Size(max = 20, message = "The phone number cannot be more than 20 characters")
    @Column(length = 20)
    @Schema(description = "Phone number of the user")
    private String phone;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Schema(description = "User creation time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Schema(description = "User update time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(Long id, String alias, String email, String password, Address address, String phone, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
