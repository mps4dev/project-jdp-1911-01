package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDto mapToProductDto(Product product) {
        if (product == null) return null;
        return new ProductDto();
    }

    public Product mapToProduct(ProductDto productDto) {
        if (productDto == null) return null;
        return new Product();
    }

    public List<ProductDto> mapToProductDtoList(List<Product> products) {
        if (products == null) return null;
        return products.stream()
                .map(product -> mapToProductDto(product))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProductList(List<ProductDto> dtoProducts) {
        if (dtoProducts == null) return null;
        return dtoProducts.stream()
                .map(product -> mapToProduct(product))
                .collect(Collectors.toList());
    }
}
