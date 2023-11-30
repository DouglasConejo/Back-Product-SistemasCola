package com.example.productback.Repository;

import com.example.productback.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT v.name, v.price, v.description,v.serialNumber FROM Product v")
    List<String[]> findProduct();
}

