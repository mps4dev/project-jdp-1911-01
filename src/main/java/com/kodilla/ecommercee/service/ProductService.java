package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        return new ProductDto();
    }

    public Product saveProduct(ProductDto productDto) {
        return new Product();
    }

    public ProductDto updateProduct(ProductDto productDto) throws ProductNotFoundException {
        return new ProductDto();
    }

    public void deleteProductById(Long id) {
    }
}
