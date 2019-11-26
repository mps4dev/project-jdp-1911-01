package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productRepository.findAll());
    }

    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        return productMapper.mapToProductDto(product);
    }

    public Product saveProduct(ProductDto productDto) {
        return productRepository.save(productMapper.mapToProduct(productDto));
    }

    public ProductDto updateProduct(ProductDto productDto) throws ProductNotFoundException {
        Product product = productRepository.findById(productDto.getId()).orElseThrow(ProductNotFoundException::new);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
        return productMapper.mapToProductDto(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
