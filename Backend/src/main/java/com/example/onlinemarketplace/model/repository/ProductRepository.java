package com.example.onlinemarketplace.model.repository;

import com.example.onlinemarketplace.model.dtos.ProductDto;
import com.example.onlinemarketplace.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.example.onlinemarketplace.model.dtos.ProductDto(p.id, p.name, p.price, p.description, c.name, p.createdAt, p.lastModifiedAt) FROM Product p LEFT JOIN p.category c WHERE p.id = :id")
    Optional<ProductDto> findProductDtoById(Long id);

    @Query("SELECT new com.example.onlinemarketplace.model.dtos.ProductDto(p.id, p.name, p.price, p.description, c.name, p.createdAt, p.lastModifiedAt) FROM Product p LEFT JOIN p.category c WHERE p.name = :name")
    Optional<ProductDto> findProductDtoByName(String name);

    @Query("SELECT new com.example.onlinemarketplace.model.dtos.ProductDto(p.id, p.name, p.price, p.description, c.name, p.createdAt, p.lastModifiedAt) FROM Product p LEFT JOIN p.category c WHERE c.name = :category_name")
    List<ProductDto> findProductsByCategoryName(String category_name);

    @Query("SELECT new com.example.onlinemarketplace.model.dtos.ProductDto(p.id, p.name, p.price, p.description, c.name, p.createdAt, p.lastModifiedAt) FROM Product p LEFT JOIN p.category c WHERE p.price = :price")
    List<ProductDto> findProductsByPrice(BigDecimal price);

    @Query("SELECT new com.example.onlinemarketplace.model.dtos.ProductDto(p.id, p.name, p.price, p.description, c.name, p.createdAt, p.lastModifiedAt) FROM Product p LEFT JOIN p.category c")
    List<ProductDto> findAllProducts();
}
