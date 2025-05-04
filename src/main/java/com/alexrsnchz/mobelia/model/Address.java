package com.alexrsnchz.mobelia.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "addresses")
@Schema(description = "Address model / entity")
public class Address {
    /*

    id:         Long    /  Required  /  Unique
    type        String  /  Required
    name        String  /  Required
    number      int     /  Required
    zipCode     String  /  Required
    city        String  /  Required
    province    String  /  Required
    country     String  /  Required
    users       List    /  Nullable
    createdAt   Date    /  Required
    updatedAt   Date    /  Required

     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Address ID", example = "1")
    private Long id;

    @NotBlank(message = "The road type cannot be empty")
    @Size(max = 50, message = "The road type cannot be more than 50 characters long")
    @Column(nullable = false, length = 50)
    @Schema(description = "Road type", example = "Avenida")
    private String type;

    @NotBlank(message = "The name cannot be empty")
    @Size(max = 50, message = "The name cannot be more than 50 characters long")
    @Column(nullable = false, length = 50)
    @Schema(description = "Name of the road", example = "Vainilla")
    private String name;

    @Min(value = 1, message = "The number must be bigger than 0")
    @Max(value = 1000, message = "The number must be lower than 1000")
    @Column(nullable = false)
    @Schema(description = "Number of the road", example = "23")
    private int number;

    @NotBlank(message = "The zip code cannot be empty")
    @Size(max = 5, message = "The zip code cannot be more than 5 characters long")
    @Column(nullable = false, length = 5)
    @Schema(description = "Zip code of the region", example = "05376")
    private String zipCode;

    @NotBlank(message = "The city/town cannot be empty")
    @Size(max = 50, message = "The city/town cannot be more than 50 characters long")
    @Column(nullable = false, length = 50)
    @Schema(description = "City/town of the address", example = "Torremolinos")
    private String city;

    @NotBlank(message = "The province cannot be empty")
    @Size(max = 50, message = "The province cannot be more than 50 characters long")
    @Column(nullable = false, length = 50)
    @Schema(description = "Province of the city/town", example = "Málaga")
    private String province;

    @NotBlank(message = "The country cannot be empty")
    @Size(max = 50, message = "The country cannot be more than 50 characters long")
    @Column(nullable = false, length = 50)
    @Schema(description = "Country of the province", defaultValue = "España", example = "España")
    private String country = "España";

    @Schema(description = "List of users that linked to the address")
    @OneToMany(mappedBy = "address")
    private List<User> users;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Schema(description = "Address creation time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @Schema(description = "Address update time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Address() {
    }

    public Address(Long id, String type, String name, int number, String zipCode, String city, String province, List<User> users, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.province = province;
        this.users = users;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
