package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.EntityNotFoundException;
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

    public List<ProductDto> getAll() {
        return productMapper.mapToProductDtoList(productRepository.findAll());
    }

    public ProductDto get(long productId) throws EntityNotFoundException {
        Product product = productRepository.findOrThrow(productId);
        return productMapper.mapToProductDto(product);
    }

    public Product create(ProductDto productDto) {
        return productRepository.save(productMapper.mapToProduct(productDto));
    }

    public ProductDto update(ProductDto productDto) throws EntityNotFoundException {
        return productMapper.mapToProductDto(productRepository.findOrThrow(productMapper.mapToProduct(productDto).getId()));
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
