package com.example.productback.Controller;

import com.example.productback.Entity.Product;
import com.example.productback.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("product")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("products")
    public List<Product> getAllPet() {
        List<String[]> queryResponse = productRepository.findProduct();
        ArrayList<Product> products = new ArrayList<>();

        queryResponse.forEach(p -> {
            Product product = new Product();
            product.setName(p[0]);
            product.setDescription(p[0]);
            product.setSerialNumber(p[0]);
            product.setPrice(p[0]);

            products.add(product);
        });

        return products;
    }


    @DeleteMapping("/product/deleteAll")
    public ResponseEntity<?> deleteAllProducts() {
        productRepository.deleteAll();
        return ResponseEntity.ok().build();
    }



}
