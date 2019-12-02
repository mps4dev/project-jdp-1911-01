package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productRepository.findAll());
    }

    public ProductDto getProductById(long id) throws ProductNotFoundException {
        Product product = productRepository.findOrThrow(id);
        return productMapper.mapToProductDto(product);
    }

    public Product saveProduct(ProductDto productDto) {
        return productRepository.save(productMapper.mapToProduct(productDto));
    }

    public ProductDto updateProduct(ProductDto productDto) throws ProductNotFoundException {
        Product product = productRepository.findOrThrow(0L); //TODO: Change 0L to productDto.getId() after ProductDto class implementation
        return productMapper.mapToProductDto(product);
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
