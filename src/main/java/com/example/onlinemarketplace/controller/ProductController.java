package com.example.onlinemarketplace.controller;

import com.example.onlinemarketplace.model.dtos.ProductDto;
import com.example.onlinemarketplace.model.entities.Product;
import com.example.onlinemarketplace.model.repository.ProductRepository;
import com.example.onlinemarketplace.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "v1/api", produces = "application/json")
//@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Search a Product by its Name. Will retrieve only the first product found with the same name.
     * @see ProductDto
     * @param name
     * @return the first instance of ProductDto of the name
     */
    @GetMapping(path = "/product/name/{name}")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable String name) {
        Optional<ProductDto> optionalProduct = productService.getProductByName(name);

        // Note to self: Do not shorten this if block. Make it readable.
        if (optionalProduct.isPresent()) {
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Search a Product by id. Since id is always unique, this GET request will always return only 1 product.
     * @see ProductDto
     * @param id
     * @return the first instance of ProductDto of its id
     */
    @GetMapping(path = "/product/id/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        Optional<ProductDto> optionalProduct = productService.getProductById(id);

        // Note to self: Do not shorten this if block. Make it readable.
        if (optionalProduct.isPresent()) {
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Search a Product by its category name.
     * @see ProductDto
     * @param category
     * @return a list of ProductDto with the same category name
     */
    @GetMapping(path = "/product/categories/{category}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable String category) {
        List<ProductDto> productDtoList = productService.getProductsByCategoryName(category);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    /**
     * Search a Product by its price.
     * @param price
     * @return a list of ProductDto with the searched price
     */
    @GetMapping(path = "/product/price/{price}")
    public ResponseEntity<List<ProductDto>> getProductsByPrice(@PathVariable BigDecimal price) {
        List<ProductDto> productDtoList = productService.getProductsByPrice(price);

        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    /**
     * Will return all Products.
     * <p>
     * ToDo: Create a paginable list of Products.
     *
     * @return a list of ProductDto
     */
    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
