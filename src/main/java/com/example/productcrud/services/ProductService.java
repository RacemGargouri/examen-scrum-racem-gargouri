package com.example.productcrud.services;

import com.example.productcrud.models.Product;
import com.example.productcrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> listAll() { return repository.findAll(); }

    public Product get(Long id) { return repository.findById(id).orElse(null); }

    public void save(Product product) { repository.save(product); }

    public void delete(Long id) { repository.deleteById(id); }
}
