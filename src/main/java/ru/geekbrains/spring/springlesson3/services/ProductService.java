package ru.geekbrains.spring.springlesson3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.springlesson3.model.Product;
import ru.geekbrains.spring.springlesson3.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Optional<Product> getOneProductById(Long id){
        return productRepository.getProductById(id);
    }

    public void save(Product product){
        productRepository.save(product);
    }
}
