package ru.geekbrains.spring.springlesson3.model;

public class Product {
    private Long id;
    private String title;
    private int cost;

    public Product(Long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }
}
