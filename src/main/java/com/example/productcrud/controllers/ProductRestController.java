package com.example.productcrud.controllers;

import com.example.productcrud.models.Product;
import com.example.productcrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> list() {
        return service.listAll();
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        service.save(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Product product, @PathVariable Long id) {
        product.setId(id);
        service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
