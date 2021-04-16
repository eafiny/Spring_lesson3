package ru.geekbrains.spring.springlesson3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.springlesson3.model.Product;
import ru.geekbrains.spring.springlesson3.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //localhost:8189/app/products/all
    @GetMapping("/all")
    public String showAllProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    //localhost:8189/app/products/{id}
    @GetMapping("/{id}")
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productService.getOneProductById(id);
        if (product.isPresent()){
            model.addAttribute("product", product.get());
        }
        return "product_info";
    }
    @GetMapping("/create")
    public String showForm(){
        return "create_product_form";
    }

    @PostMapping("/create")
    public String createNewProduct(@RequestParam String title, @RequestParam int cost){
        Product product = new Product(null,title, cost);
        productService.save(product);
        return "redirect:/products/all";
    }

}
