package ru.geekbrains.spring.springlesson3.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.springlesson3.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(Arrays.asList(
                new Product(0L, "Product1", (int)(Math.random()*1000)),
                new Product(1L, "Product2", (int)(Math.random()*1000)),
                new Product(2L, "Product3", (int)(Math.random()*1000)),
                new Product(3L, "Product4", (int)(Math.random()*1000))
        ));
    }

    public List<Product> getAllProducts(){
        return productList;
    }

    public Optional<Product> getProductById(Long id){
        for (Product p:productList) {
            if (p.getId().equals(id)) {return Optional.of(p);}
        }
        return Optional.empty();
    }

    public void save(Product product) {
        product.setId((long) productList.size());
        productList.add(product);
    }
}
