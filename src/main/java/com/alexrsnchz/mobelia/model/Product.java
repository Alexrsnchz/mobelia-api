package com.alexrsnchz.mobelia.model;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String style;
    private String material;
    private String color;
    private float height;
    private float width;
    private float depth;
    private float weight;

    public Product() {
    }

}
