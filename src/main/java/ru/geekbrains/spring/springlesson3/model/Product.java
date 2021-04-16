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
    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
