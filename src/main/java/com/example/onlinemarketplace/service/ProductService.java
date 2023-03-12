package com.example.onlinemarketplace.service;

import com.example.onlinemarketplace.model.dtos.ProductDto;
import com.example.onlinemarketplace.model.entities.Product;
import com.example.onlinemarketplace.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<ProductDto> getProductByName(String name) {
        return productRepository.findProductDtoByName(name);
    }

    public Optional<ProductDto> getProductById(Long id) {
        return productRepository.findProductDtoById(id);
    }

    public List<ProductDto> getProductsByCategoryName(String name) {
        return productRepository.findProductsByCategoryName(name);
    }

    public List<ProductDto> getProductsByPrice(BigDecimal price) {
        return productRepository.findProductsByPrice(price);
    }
}
