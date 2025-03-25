package com.alexrsnchz.mobelia.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name is required")
    @Size(min = 3, max = 100, message = "The name must be between 3 and 100 characters")
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank(message = "The description is required")
    @Size(max = 500, message = "The description must have at most 500 characters")
    private String description;

    @NotNull(message = "The price is required")
    @Positive(message = "The price must be greater than 0")
    private Float price;

    @NotNull(message = "The stock is required")
    @Min(value = 0, message = "The stock cannot be negative")
    private Integer stock;

    @NotBlank(message = "The image is required")
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @NotNull(message = "The category is required")
    private Category category;

    @NotBlank(message = "The style is required")
    @Size(max = 50, message = "The style must have at most 50 characters")
    private String style;

    @NotBlank(message = "The material is required")
    @Size(max = 50, message = "The material must have at most 50 characters")
    private String material;

    @NotBlank(message = "The color is required")
    @Size(max = 50, message = "The color must have at most 50 characters")
    private String color;

    @NotNull(message = "The height is required")
    @Positive(message = "The height must be greater than 0")
    private Float height;

    @NotNull(message = "The width is required")
    @Positive(message = "The width must be greater than 0")
    private Float width;

    @NotNull(message = "The depth is required")
    @Positive(message = "The depth must be greater than 0")
    private Float depth;

    @NotNull(message = "The weight is required")
    @Positive(message = "The weight must be greater than 0")
    private Float weight;

    public Product() {
    }

    public Product(Long id, String name, String description, float price, int stock, String image, Category category, String style, String material, String color, float height, float width, float depth, float weight) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.category = category;
        this.style = style;
        this.material = material;
        this.color = color;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
